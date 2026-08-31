(ns association.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private authored
  "data/datascript-tx.edn is the authored copy; `catalog` is a reading of it."
  (edn/read-string (slurp "data/datascript-tx.edn")))

(deftest the-fixture-reads-a-real-catalog
  ;; Every assertion below is per-entry, so an empty catalog would satisfy all
  ;; of them. This is the floor that keeps "there was nothing to check" from
  ;; looking like "everything checked out".
  (is (pos? (count authored)))
  (is (= (count authored) (count (facts/spec-basis "conep")))))

(deftest catalog-agrees-with-the-authored-data-file
  ;; The .cljc holds the catalog inline, the way the sibling repos do, so the
  ;; risk is transcription: a dropped field, a mistyped url, a quote that no
  ;; longer matches the one the live checker will look for. Compare field by
  ;; field rather than by count.
  (doseq [[i [a c]] (map-indexed vector (map vector authored (facts/spec-basis "conep")))]
    (testing (str "entry " i " (" (:association-rule/id a) ")")
      (is (= (set (keys a)) (set (keys c)))
          "the same fields, neither more nor fewer")
      (doseq [k (sort (keys a))]
        (testing (str k)
          (is (= (if (= k :association-rule/topic) (set (k a)) (k a))
                 (if (= k :association-rule/topic) (set (k c)) (k c)))))))))

(deftest conep-has-spec-basis
  (let [sb (facts/spec-basis "conep")]
    (is (= 11 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "PAN" (:association-rule/country %)) sb))
    (is (every? #(seq (:association-rule/source-quote %)) sb)
        "an entry with no quoted span cannot be checked against its own source")
    (is (every? #(seq (:association-rule/source-article %)) sb))
    (is (= (count sb) (count (set (map :association-rule/id sb))))
        "ids are the federation's identity attribute")))

(deftest every-entry-is-dated-and-carries-provenance
  (doseq [e (facts/spec-basis "conep")]
    (testing (:association-rule/id e)
      (is (or (:association-rule/established-date e)
              (:association-rule/last-revised-date e)))
      (is (keyword? (:association-rule/url-provenance e))))))

(deftest the-founding-fact-is-day-precise-from-the-primary-source
  ;; This is the fact the catalog was created unable to state. It is asserted
  ;; here so that a regression to the month-precision ceib.info reading, or to
  ;; the old id, fails rather than passing as "still one governance entry".
  (let [f (first (filter #(= "conep.founding-1964-07-03" (:association-rule/id %))
                         (facts/spec-basis "conep")))]
    (is (some? f))
    (is (= "1964-07-03" (:association-rule/established-date f)))
    (is (= :official-conep-org-pa (:association-rule/url-provenance f)))
    (is (= "1" (:association-rule/source-article f)))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "cciap")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["conep" "cciap"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["cciap"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 11 (count (facts/by-topic "conep" :governance))))
  (is (empty? (facts/by-topic "conep" :labor)))
  (is (empty? (facts/by-topic "cciap" :governance))))
