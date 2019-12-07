package test.java;

import d01.Rocket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay1 {

    @Test
    public void fuelCalculate() {
        Rocket r = new Rocket();
        assertEquals(r.calculateFuel(12),2);
        assertEquals(r.calculateFuel(14),2);
        assertEquals(r.calculateFuel(1969),654);
        assertEquals(r.calculateFuel(100756),33583);
    }

    @Test
    public void extendedFuelCalculate() {
        Rocket r = new Rocket();
        assertEquals(r.extendedCalculateFuel(14),2);
        assertEquals(r.extendedCalculateFuel(1969),966);
        assertEquals(r.extendedCalculateFuel(100756),50346);
    }
}
