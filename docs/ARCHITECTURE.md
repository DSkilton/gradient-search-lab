# Architecture — GradientSearchLab

## Proposed pipeline

Reproducible objective -> fixed direction -> compare candidate step losses -> record evaluations/time -> compare tuned optimisers -> statistical reports.

## Initial implementation

`ComparisonStepSearch` is a tiny in-memory experimental baseline with deterministic unit tests. It deliberately has no external integrations, databases or model dependencies yet.

## Principles

- Java 21 core and explicit interfaces for external dependencies.
- Strictly typed, documented input units and schema versions.
- Separate raw data, processed features, models and derived results.
- Record provenance and licence for every external dataset.
- Keep experiments reproducible and isolate resource-intensive steps.
- Add database, APIs and queues only when an evaluated use case requires them.
