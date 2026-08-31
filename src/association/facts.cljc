(ns association.facts
  "Industry rule/history catalog for CoNEP (Consejo Nacional de la Empresa
  Privada, Panama) -- a 72nd industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci, -9411-arg-uia,
  -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek, -9411-tha-fti,
  -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep, -9411-ecu-cip,
  -9411-egy-fei, -9411-pry-uip, -9411-ury-ciu, -9411-pol-lewiatan,
  -9411-prt-cip for the first twenty-nine) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The THIRTIETH entry aligned to
  ISIC 9411 (activities of business, employers, and professional membership
  organizations).

  SOURCING, and how it changed. On 2026-07-18 conep.org.pa returned HTTP 403
  Forbidden on every attempt, so this catalog was seeded with a single fact --
  a July 1964 founding at MONTH precision, corroborated from ceib.info, an
  independent international business-federation directory -- and said so
  rather than forcing a second, weaker entry.

  On 2026-08-31 that block was re-measured and is gone: conep.org.pa answers
  200, and it publishes its own Estatutos, approved 24 November 2021, as both
  a page and a PDF. Article 1 of that instrument gives the founding date at
  DAY precision -- 3 de julio de 1964 -- which supersedes the month-precision
  reading, and the remaining articles are the association's own governance
  rules, which is what an association-rule catalog is for. The eleven entries
  below are all read directly from that primary source.

  The entry id changed with the precision: `conep.founding-1964-07` became
  `conep.founding-1964-07-03`. A query pinning the old id finds nothing; that
  is the intended signal, because the old id encoded a precision the source no
  longer forces us to accept.

  Provenance is checkable, not asserted. Every entry carries the article it
  comes from and the verbatim span it rests on, and
  `nbb scripts/verify-catalog.cljs --live` fetches each :url and fails if the
  document no longer contains that span. Reachability alone would not do:
  a URL that returns 200 without the claim is indistinguishable from one that
  supports it, which is exactly how a citation rots without anyone noticing.

  `data/datascript-tx.edn` is the authored copy. This catalog and
  `src/association_facts.kotoba` are both readings of it, and both are held to
  it -- this one by test/association/facts_test.clj, the Kotoba port by
  `nbb scripts/gen-kotoba-port.cljs --check`.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"conep"
   [{:association-rule/id "conep.founding-1964-07-03"
     :association-rule/title "Consejo Nacional de la Empresa Privada (CoNEP) founded in Panama City on 3 July 1964; a non-profit, non-political civil association constituted under ordinal 5 of article 64 of Panama's Civil Code (CoNEP's own Estatutos, article 1)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "1"
     :association-rule/source-quote "fundado en la ciudad de Panamá, República de Panamá, el 3 de julio de 1964"
     :association-rule/established-date "1964-07-03"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.estatutos-2021-11-24"
     :association-rule/title "CoNEP's Estatutos currently in force were approved on 24 November 2021; they are the instrument every article-level rule in this catalog is read from (conep.org.pa's own Estatutos page)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/estatutos/"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "preamble"
     :association-rule/source-quote "(Aprobados el 24 de noviembre de 2021)"
     :association-rule/established-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.membership-eligibility-art-5"
     :association-rule/title "Membership of CoNEP is open to duly constituted business and professional associations of recognised moral standing, admitted as such by the Council (Estatutos article 5)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "5"
     :association-rule/source-quote "Podrán formar parte del CoNEP, en calidad de miembro, las asociaciones empresariales y profesionales debidamente constituidas"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.member-dues-forfeiture-art-9"
     :association-rule/title "A CoNEP member three or more months in arrears on dues temporarily loses its vote; at six months it loses membership permanently, by absolute majority (Estatutos article 9)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "9"
     :association-rule/source-quote "Perderá temporalmente el derecho a voto el miembro en mora en el pago de sus cuotas, ordinarias o extraordinarias por tres o más meses"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.council-cadence-art-10"
     :association-rule/title "The Council meets at least every two months, and additionally whenever convened by the President or requested by four of its members (Estatutos article 10)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "10"
     :association-rule/source-quote "El Consejo se reunirá por lo menos cada dos (2) meses"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.board-composition-art-12"
     :association-rule/title "The Junta Directiva is seven elected directors plus the immediate past president, eight voting in total, for a one-year term running 1 January to 31 December (Estatutos article 12)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "12"
     :association-rule/source-quote "conformada por siete (7) directores más el Expresidente inmediato, para un total de ocho (directores) con voz y voto, por el período de un (1) año"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.board-cadence-art-13"
     :association-rule/title "The Junta Directiva meets at least once a month, and representatives of all member associations may attend in addition to its own members (Estatutos article 13)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "13"
     :association-rule/source-quote "La Junta Directiva se reunirá por lo menos una vez al mes"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.board-quorum-art-14"
     :association-rule/title "Quorum for a Junta Directiva meeting is at least five of its members (Estatutos article 14)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "14"
     :association-rule/source-quote "El quórum necesario para la celebración de las reuniones de la Junta Directiva será al menos de cinco (5) de sus miembros"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.president-partisan-ban-art-17"
     :association-rule/title "While in office the CoNEP president may not take an active part in partisan politics, on pain of immediate suspension, and may not simultaneously preside over any other trade body or business council (Estatutos article 17)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "17"
     :association-rule/source-quote "El (la) presidente(a) mientras ejerza el cargo, no podrá participar activamente en política partidista"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.statute-reform-threshold-art-21"
     :association-rule/title "The Estatutos may be reformed in whole or in part by at least 66% of the voting members present at an extraordinary assembly convened for that purpose with quorum (Estatutos article 21)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "21"
     :association-rule/source-quote "Los Estatutos podrán ser reformados total o parcialmente, mediante el voto a favor de al menos 66% de los miembros presentes"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}
    {:association-rule/id "conep.dissolution-threshold-art-22"
     :association-rule/title "CoNEP may be dissolved only at an extraordinary meeting convened for that purpose with at least 15 days notice and at least 75% of voting members in favour (Estatutos article 22)"
     :association-rule/association "conep"
     :association-rule/isic "9411"
     :association-rule/country "PAN"
     :association-rule/kind :governance-program
     :association-rule/url "https://conep.org.pa/wp-content/uploads/2026/04/estatutos_conep_completo.pdf"
     :association-rule/url-provenance :official-conep-org-pa
     :association-rule/source-article "22"
     :association-rule/source-quote "La disolución del CoNEP podrá ser acordada ÚNICAMENTE en reunión extraordinaria convocada para tal efecto, con no menos de 15 días de anticipación"
     :association-rule/last-revised-date "2021-11-24"
     :association-rule/retrieved-at "2026-08-31"
     :association-rule/topic #{:governance}}]}
)

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
                 (count (get catalog "conep")) " CoNEP entries, each citing "
                 "conep.org.pa's own Estatutos with the article and the verbatim "
                 "span it rests on. Extend `association.facts/catalog`, never "
                 "fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
