package test.java;

import d07.Permutation;
import d07.SolutionDay7;
import org.junit.jupiter.api.Test;
import utils.ParseUtil;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay7 {

    @Test
    public void maxTrustedSignalWithOneLoopCaseOne() {
        SolutionDay7 solutionDay7 = new SolutionDay7();
        int[] ints = new int[]{3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0};
        Permutation p = new Permutation();
        p.permute(Arrays.asList(0, 1, 2, 3, 4), 0);
        int results = solutionDay7.calculatePartOne(ints);
        assertEquals(results,43210);
    }

    @Test
    public void maxTrustedSignalWithOneLoopCaseTwo() {
        SolutionDay7 solutionDay7 = new SolutionDay7();
        int[] ints = new int[]{3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0};
        Permutation p = new Permutation();
        p.permute(Arrays.asList(0, 1, 2, 3, 4), 0);
        int results = solutionDay7.calculatePartOne(ints);
        assertEquals(results,54321);
    }

    @Test
    public void maxTrustedSignalWithOneLoopCaseThree() {
        SolutionDay7 solutionDay7 = new SolutionDay7();
        int[] ints = new int[]{3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0};
        Permutation p = new Permutation();
        p.permute(Arrays.asList(0, 1, 2, 3, 4), 0);
        int results = solutionDay7.calculatePartOne(ints);
        assertEquals(results,65210);
    }

}
