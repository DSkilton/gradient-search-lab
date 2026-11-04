# GradientSearchLab

Directional-feedback and comparison-based optimisation experiments

> **Research prototype — not a production system.** The starter is a one-dimensional convex toy search, not neural-network training; its result cannot establish a training speedup.

## Research objective

Test whether comparison-only line searches along a known descent direction can reduce expensive backward passes without increasing total training time.

**Research question:** When gradients are costly, can bounded comparisons of forward losses reduce end-to-end wall time against properly tuned conventional optimisers?

## Technology

- Java 21 + Gradle 9.8.2
- JUnit 5 for deterministic baseline tests
- Later: PostgreSQL and Python ML dependencies only if experiments justify them
- Unit conventions, experimental assumptions and data provenance are documented before running real datasets

## What exists today

A **small, runnable Java toy baseline** (`ComparisonStepSearch`) and a corresponding JUnit test. These are scaffolding, not scientific results. There are no external datasets, ML models, secrets or production integrations in the initial commit.

## Quick start

Install JDK 21 and Gradle 9.8.2, then:

```bash
gradle clean test
```

The official Gradle Wrapper is a follow-up issue; do not run `./gradlew` until it is generated and committed.

## Directory structure

```text
src/main/java/dev/dskilton/gradientsearchlab/     Java baseline
src/test/java/dev/dskilton/gradientsearchlab/     JUnit experiments/tests
docs/RESEARCH.md                                  Hypothesis and evaluation
docs/ARCHITECTURE.md                              Proposed components
docs/ROADMAP.md                                   Incremental milestones
docs/DATA_POLICY.md                               Data licensing and reproducibility
.github/workflows/ci.yml                          Java CI
```

## Data and scientific integrity

The starter is a one-dimensional convex toy search, not neural-network training; its result cannot establish a training speedup.

Raw datasets, secrets, model checkpoints and private artefacts must not be committed. Record all source citations, licences, acquisition dates, split logic and evaluation decisions; do not state model performance until it has been independently measured.

Read [research plan](docs/RESEARCH.md), [roadmap](docs/ROADMAP.md), [architecture](docs/ARCHITECTURE.md) and [data policy](docs/DATA_POLICY.md). Issues break the research into small, reviewable PRs.
