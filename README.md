# cloud-itonami-assoc-9411-pan-conep

Industry rule/history catalog for **CoNEP** (Consejo Nacional de la Empresa
Privada, Panama) — the THIRTIETH entry aligned to **ISIC 9411** (activities of
business, employers, and professional membership organizations), alongside
[`-9411-prt-cip`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-prt-cip)
(Portugal),
[`-9411-pol-lewiatan`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-pol-lewiatan)
(Poland), and 28 other national industry/employers associations. Part of the
[`cloud-itonami`](https://github.com/cloud-itonami) compliance-fact family
(ADR-2607141700, `cloud-itonami-compliance-fact-federation`, in
`com-junkawasaki/root`), and registered in that superproject's
`scripts/compliance-fact-query.cljs` federation.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor actuation
actor. It proposes or executes nothing on CoNEP's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never fabricate
one.

## The sourcing block is gone, and the catalog changed because of it

When this repo was seeded on 2026-07-18, `conep.org.pa` returned **HTTP 403
Forbidden** on every attempt. The catalog therefore held a single fact — a July
1964 founding at **month** precision, corroborated from `ceib.info`, an
independent international business-federation directory — and said so rather
than forcing a second, weaker entry.

That block was re-measured on **2026-08-31 and is gone.** `conep.org.pa`
answers `200`, and it publishes its own **Estatutos, approved 24 November
2021**, as a page and as a PDF. Two things follow:

- **The founding date is now day-precise from the primary source.** Article 1
  reads *"fundado en la ciudad de Panamá, República de Panamá, el 3 de julio de
  1964"*. This supersedes the month-precision reading.
- **The articles are CoNEP's own governance rules**, which is what an
  association-rule catalog is for. The catalog now holds **11 entries**, every
  one read directly from that primary source.

⚠ **The founding entry's id changed with its precision**:
`conep.founding-1964-07` → `conep.founding-1964-07-03`. `:association-rule/id`
is the federation's `:db.unique/identity`, so a query pinning the old id now
finds nothing. That is the intended signal — the old id encoded a precision the
source no longer forces on us.

## Provenance is checkable, not asserted

Every entry carries the article it comes from (`:association-rule/source-article`)
and the **verbatim span it rests on** (`:association-rule/source-quote`).

```bash
nbb scripts/verify-catalog.cljs           # structural only, offline
nbb scripts/verify-catalog.cljs --live    # fetch every :url, require every quote
```

`--live` does not ask whether the citation *resolves*. It asks whether the
document **still says the thing the entry says it says**. Reachability alone
cannot tell those apart: a URL that returns `200` without the claim looks
exactly like one that supports it — the sibling `threat-intelligence` catalog
was caught by precisely that, with two feeds returning `200` and nothing but
comment lines, one of them stating in its own body that it had been deprecated.

Exit codes are three-valued on purpose:

| exit | meaning |
|---|---|
| `0` | checked, nothing wrong |
| `1` | checked, findings printed |
| `2` | **REFUSED** — could not check (unreadable catalog, dead source, no `pdftotext`) |

`2` exists so that *"I could not check"* and *"I checked and it was fine"* do
not leave the same trace. A dead citation refuses rather than reporting
`quote-not-in-source`, because every quote would be "not found" and that reads
identically to a fabricated catalog.

## Data, and which copy is authored

`data/datascript-tx.edn` is the **authored** copy. The other two are readings of
it, and each is held to it by something that fails:

| file | what it is | held to the data by |
|---|---|---|
| `data/datascript-tx.edn` | authored catalog, DataScript tx-data | — |
| `src/association/facts.cljc` | the catalog as Clojure | `test/association/facts_test.clj` (field by field) |
| `src/association_facts.kotoba` | the catalog as Kotoba — reaches the Kotoba oracle, wasm, and both native ISAs | `nbb scripts/gen-kotoba-port.cljs --check` |

`test/association_facts_kotoba_parity_test.clj` closes the third edge, comparing
`.cljc` against `.kotoba` field by field, so no two of the three can drift apart
silently.

```bash
nbb scripts/gen-kotoba-port.cljs          # regenerate the port
nbb scripts/gen-kotoba-port.cljs --check  # exit 1 if someone hand-edited it
clojure -M:test                            # both suites
```

`schema/association-rule.edn` is the DataScript schema. `:source-article` and
`:source-quote` are plain attributes with no `:db/unique` or `:db/cardinality`,
so merging this schema alongside sibling schemas that lack them is a no-op for
those siblings.

## Known gaps

- **`ceib.info` is no longer cited.** It was the fallback while the primary
  source was blocked, and the primary now states the same fact at higher
  precision. The corroboration is recorded here rather than in the catalog.
- **`--live` needs `pdftotext`** for the Estatutos PDF. Without it the run
  refuses (exit `2`) rather than skipping the PDF's nine entries quietly.
- **Board membership is deliberately not catalogued.** `conep.org.pa` publishes
  the sitting Junta Directiva by name; `organization.edn` records institutional
  titles only, and this catalog holds no personal names.
- **The catalog is bylaws-only.** CoNEP also publishes dated press positions
  (`Notas de Prensa`) and a legislative tracker (`Entorno Legislativo`); neither
  has been read.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` / `-municipality-*` /
`-assoc-*` / `-lei-*` convention).
