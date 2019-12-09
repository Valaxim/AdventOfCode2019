package test.java;

import d04.SolutionDay4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDay4 {

    @Test
    public void noPairValidation() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertFalse(solutionDay4.validatePair(123402));
    }

    @Test
    public void pairValidation() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertTrue(solutionDay4.validatePair(122402));
    }

    @Test
    public void noIncreasingTest() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertFalse(solutionDay4.validateIncreasing(123402));
    }

    @Test
    public void correctIncreasingTest() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertTrue(solutionDay4.validateIncreasing(123789));
    }

    @Test
    public void validateGroupOfSixTest() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertFalse(solutionDay4.validateGroup(777777));
    }

    @Test
    public void validateDoubleGroupTest() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertTrue(solutionDay4.validateGroup(337777));
    }

    @Test
    public void validateTripleGroupTest() {
        SolutionDay4 solutionDay4 = new SolutionDay4();
        assertTrue(solutionDay4.validateGroup(337788));
    }
}
