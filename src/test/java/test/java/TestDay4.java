package test.java;

import d04.Day4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDay4 {

    @Test
    public void noPairValidation() {
       assertFalse(Day4.validatePair(123402));
    }

    @Test
    public void pairValidation() {
        assertTrue(Day4.validatePair(122402));
    }

    @Test
    public void noIncreasingTest() {
        assertFalse(Day4.validateIncreasing(123402));
    }

    @Test
    public void correctIncreasingTest() {
        assertTrue(Day4.validateIncreasing(123789));
    }

    @Test
    public void validateGroupOfSixTest() {
        assertFalse(Day4.validateGroup(777777));
    }

    @Test
    public void validateDoubleGroupTest() {
        assertTrue(Day4.validateGroup(337777));
    }

    @Test
    public void validateTripleGroupTest() {
        assertTrue(Day4.validateGroup(337788));
    }

  //  boolean c1 = validateIncreasing(123402);
   // boolean c2 = validateIncreasing(123789);
   // boolean d1 = validateGroup(803659);

}
