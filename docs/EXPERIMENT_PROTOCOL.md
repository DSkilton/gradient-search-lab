# Pre-registered experiment protocol (v0.1)

**Status:** experimental design. No measured neural-network speedup is claimed.

## Central hypothesis

Replacing selected expensive gradient/backward evaluations with bounded **forward-only loss comparisons along a known candidate direction** might improve total training wall time, **without reducing final model quality**, on workloads where backward is substantially more expensive than forward. A null or negative result is acceptable.

This is NOT equivalent to binary-searching each network weight or recovering target labels from binary feedback. The starter `ComparisonStepSearch` performs a ternary interval search for a one-dimensional unimodal loss; it does not use a gradient or train a neural network.

## Independent variables

- Step-size selection strategy: fixed learning rate, grid search, golden-section/ternary comparison, Armijo/backtracking line search, and hybrid approach.
- Workload: convex synthetic, noisy/nonconvex synthetic, then small neural network.
- Candidate direction: fixed descent direction produced by a baseline gradient; record exactly when a new gradient is evaluated.
- Search budget: equal objective evaluations and separately equal total wall-clock budgets.

## Controlled comparisons

Use tuned SGD/Adam baselines rather than an intentionally weak constant learning rate. Repeat with the same datasets, seeds, splits, model architecture, dtype, device and stopping thresholds. The hybrid must include all forward evaluations needed to find a step. Do not hide gradient cost within preprocessing.

## Measurement ledger (per run)

| Field | Meaning |
| --- | --- |
| `seed`, `git_sha`, `environment` | Exact reproducibility |
| `device`, `dtype`, `batch_size` | Hardware and numerical setup |
| `forward_calls`, `backward_calls` | Total actual evaluations, including rejected candidates |
| `elapsed_ns` | Monotonic time, after device synchronisation on GPU |
| `final_loss`, `held_out_metric` | Training progress and generalisation |
| `target_reached`, `stop_reason` | Quality/termination criteria |
| `energy_wh` (optional) | Measured power usage if available |

## Primary and secondary outcomes

Primary: **wall-clock time to reach a predeclared validation-loss threshold** on the same hardware; also record fraction of runs reaching the target. Secondary: forward/backward evaluation counts, final held-out metric, peak memory, energy and robustness to noisy loss comparisons. Faster time per iteration alone is not a success criterion.

## Repetition and statistics

Use at least five documented seeds for toy studies, increasing repetitions after inspecting variability; do not select seeds based on favourable outcomes. Show individual results and median/IQR or uncertainty intervals. Report failed runs, GPU warmup, compilation time and hyperparameter-search overhead separately.

## Staged experiments

1. **Toy deterministic convex:** validate known optima and exact call accounting; compare matched evaluation budgets.
2. **Toy noisy and nonconvex:** repeat seeds, include multiple minima and intervals that violate unimodality assumptions.
3. **Small deep learning:** fixed dataset/model and fair tuned baselines; measure real CPU and GPU wall time, synchronising GPU before/after timing.
4. **Ablation:** vary gradient expense, candidate count, noise and stopping quality. Explain any win or loss.

## Research integrity

Freeze the protocol before collecting benchmark outcomes. If changed, version this document and identify exploratory vs preregistered results. Publish negative findings and full computational costs. Never interpret a toy interval search as proof of neural-network training efficiency.

Version 0.1 (2026-11-04): initial fair-comparison measurement definitions.
