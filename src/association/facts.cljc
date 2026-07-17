(ns association.facts
  "Industry rule/history catalog for CONEP (Consejo Nacional de la
  Empresa Privada, Panama) -- a 72nd industry-association-level
  source (see cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko,
  -9411-irl-ibec, -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii,
  -9411-zaf-busa, -9411-bra-cni, -9411-ken-kam, -9411-can-chamber,
  -9411-mex-coparmex, -9411-ita-confindustria, -9411-nld-vnoncw,
  -9411-kor-kcci, -9411-arg-uia, -9411-bel-feb, -9411-dnk-di,
  -9411-swe-sn, -9411-fin-ek, -9411-tha-fti, -9411-chl-sofofa,
  -9411-col-andi, -9411-cri-uccaep, -9411-ecu-cip, -9411-egy-fei,
  -9411-pry-uip, -9411-ury-ciu, -9411-pol-lewiatan, -9411-prt-cip for
  the first twenty-nine) per ADR-2607141700 (cloud-itonami-compliance-
  fact-federation). The THIRTIETH entry aligned to ISIC 9411
  (activities of business, employers, and professional membership
  organizations). Fills Panama's previously-open association-axis gap
  -- one of the 2 remaining countries (GTM/HND) after Portugal closed
  at tick 169. Panama now has real, individually verified facts
  across ALL THREE axes (country: cloud-itonami-iso3166-pan
  statute.facts, pre-existing; municipality:
  cloud-itonami-municipality-pan-panama-city, added tick 165;
  association: this entry).

  IMPORTANT SOURCING LIMITATION, documented honestly: conep.org.pa
  itself returned HTTP 403 Forbidden on every direct WebFetch attempt
  this tick (both '/quienes-somos/' and the older
  '/contenidos-estaticos/quienes-somos/' path), so CONEP's own
  founding claim could NOT be independently verified by directly
  reading the primary source. Instead, ceib.info (CEIB, an
  independent international business-federation directory) was
  directly read and states verbatim: 'En julio de 1964, en la ciudad
  de Panamá, apareció el Consejo Nacional de la Empresa Privada' (In
  July 1964, in Panama City, the National Council of Private
  Enterprise appeared) -- month/year precision only, no day. No
  Wikipedia article exists for CONEP. Despite checking conep.org.pa
  (blocked), ceib.info, EU-LAC Foundation's public and intranet pages
  (no usable content, intranet is a login wall), and a Wikipedia
  search (no article), only ONE precisely-dateable milestone (at
  month precision) could be found -- rather than force a second,
  weaker fact, this catalog honestly contains a single entry (matching
  the precedent set for Ecuador's CIP at tick 159 and Uruguay's CIU
  at tick 162, which also used a single fact when a second could not
  be verifiably sourced).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"conep"
   [{:association-rule/id "conep.founding-1964-07"
     :association-rule/title "Consejo Nacional de la Empresa Privada (CONEP) founded July 1964 in Panama City (conep.org.pa itself returned HTTP 403; independently corroborated by ceib.info's directly-read entry)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.ceib.info/en/node/34"
     :association-rule/url-provenance :ceib-info-corroborated
     :association-rule/established-date "1964-07"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-pan-conep Wave 0 (ADR-2607141700): "
                 (count (get catalog "conep")) " CONEP entry seeded "
                 "with ceib.info corroboration (conep.org.pa itself returned HTTP 403 on every "
                 "direct fetch attempt, and no Wikipedia article exists -- only one precisely "
                 "dateable fact, at month precision, could be verified). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
