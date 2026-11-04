package dev.dskilton.gradientsearchlab;

import java.util.function.DoubleUnaryOperator;

/**
 * Comparison-only interval search over a 1D convex loss.
 * Uses two forward loss evaluations per round; no backward pass.
 * Convexity/unimodality assumptions are NOT verified by this algorithm.
 */
public final class ComparisonStepSearch {
    private ComparisonStepSearch() {}

    public record Result(double step, double loss, int forwardEvaluations) {}

    public static Result find(
            DoubleUnaryOperator loss,
            double lower,
            double upper,
            int rounds) {
        if (loss == null || !Double.isFinite(lower) || !Double.isFinite(upper)
                || lower >= upper || rounds < 1 || rounds > 1000) {
            throw new IllegalArgumentException("Valid bounds and 1..1000 rounds required");
        }
        int evaluations = 0;
        for (int i = 0; i < rounds; i++) {
            double left = lower + (upper - lower) / 3.0;
            double right = upper - (upper - lower) / 3.0;
            double leftLoss = loss.applyAsDouble(left);
            double rightLoss = loss.applyAsDouble(right);
            evaluations += 2;
            if (!Double.isFinite(leftLoss) || !Double.isFinite(rightLoss)) {
                throw new IllegalArgumentException("Objective returned a nonfinite loss");
            }
            if (leftLoss <= rightLoss) {
                upper = right;
            } else {
                lower = left;
            }
        }
        double step = lower + (upper - lower) / 2.0;
        double finalLoss = loss.applyAsDouble(step);
        if (!Double.isFinite(finalLoss)) {
            throw new IllegalArgumentException("Objective returned a nonfinite loss");
        }
        return new Result(step, finalLoss, evaluations + 1);
    }
}
