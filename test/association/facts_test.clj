(ns association.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest conep-has-spec-basis
  (let [sb (facts/spec-basis "conep")]
    (is (= 1 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "https://") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "PAN" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "cciap")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["conep" "cciap"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["cciap"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 1 (count (facts/by-topic "conep" :governance))))
  (is (empty? (facts/by-topic "conep" :labor)))
  (is (empty? (facts/by-topic "cciap" :governance))))
