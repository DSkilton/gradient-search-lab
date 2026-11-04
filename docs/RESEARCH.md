# Research plan — GradientSearchLab

## Problem

Test whether comparison-only line searches along a known descent direction can reduce expensive backward passes without increasing total training time.

## Primary research question

When gradients are costly, can bounded comparisons of forward losses reduce end-to-end wall time against properly tuned conventional optimisers?

## Hypothesis

A carefully defined baseline and controlled experiment can test whether proposed improvements offer measurable gains. **No improvement is assumed.**

## Evaluation plan

1. Declare data inclusion/exclusion, timestamps, units, licensing and provenance.
2. Establish deterministic and conventional baselines.
3. Pre-register metrics, random seeds, computational budgets and splitting strategy.
4. Compare held-out results with appropriate uncertainty intervals.
5. Document failure cases, leakage risks, limitations and reproducibility instructions.

## Initially approved data

- Generated convex, nonconvex and noisy one-dimensional loss functions
- Later: seeded neural-network benchmarks with wall-clock, forward/backward counts, and GPU synchronisation

## Scientific boundary

The starter is a one-dimensional convex toy search, not neural-network training; its result cannot establish a training speedup.

## Publication notes

Keep assumptions, negative findings, experiment versions and citations in the repository. Draft findings only after experiments and independent checks.
