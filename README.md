# cloud-itonami-assoc-9411-pan-conep

Industry rule/history catalog for **CONEP** (Consejo Nacional de la
Empresa Privada, Panama) — the THIRTIETH entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-prt-cip`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-prt-cip)
(Portugal),
[`-9411-pol-lewiatan`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-pol-lewiatan)
(Poland), and 28 other national industry/employers associations.
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Fills one of the 2 remaining countries (GTM/HND) after Portugal closed
at tick 169. Panama now has real, individually verified facts across
**all three axes** (country, municipality, association).

## Sourcing limitation (documented honestly)

`conep.org.pa` itself returned **HTTP 403 Forbidden** on every direct
fetch attempt this tick, so CONEP's own founding claim could not be
independently verified by directly reading the primary source.
Instead, `ceib.info` (an independent international business-federation
directory) was directly read and confirms a July 1964 founding in
Panama City — month/year precision only, no day. No Wikipedia article
exists for CONEP. Only this one precisely-dateable fact (at month
precision) could be verified despite checking multiple sources, so
this catalog honestly contains a single entry rather than forcing a
second, weaker one.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CONEP's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
