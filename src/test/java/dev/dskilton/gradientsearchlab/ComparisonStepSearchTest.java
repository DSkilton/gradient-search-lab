package dev.dskilton.gradientsearchlab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ComparisonStepSearchTest {
    @Test
    void findsOptimumOfToyQuadraticUsingComparisons() {
        var result = ComparisonStepSearch.find(step -> (step - 2) * (step - 2), 0, 5, 25);
        assertEquals(2, result.step(), 0.001);
        assertTrue(result.loss() < 0.000001);
        assertEquals(51, result.forwardEvaluations());
    }

    @Test
    void rejectsInvalidBounds() {
        assertThrows(IllegalArgumentException.class,
                () -> ComparisonStepSearch.find(x -> x * x, 3, 1, 10));
    }
}
