package test.java;

import d02.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay2 {

    @Test
    public void intcodeShouldReturnTwo() {
        Solution s = new Solution();
        s.setArray(new int[]{1, 0, 0, 0, 99});
        assertEquals(2, s.execute());

    }

    @Test
    public void shouldReturnTwo() {
        Solution s = new Solution();
        s.setArray(new int[]{2, 3, 0, 3, 99});
        assertEquals(2, s.execute());
    }

    @Test
    public void intcodeShouldReturnThirty() {
        Solution s = new Solution();
        s.setArray(new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99});
        assertEquals(30, s.execute());
    }

    @Test
    public void intcodeShouldReturnThreeThousandFiftyHundred() {
        Solution s = new Solution();
        s.setArray(new int[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50});
        assertEquals(3500, s.execute());
    }
}
