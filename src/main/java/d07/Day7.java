package d07;

import d05.Day5;
import utils.ParseUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day7 extends Day5 {
    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        int[] ints = parser.readInputContainsIntegers("inputDay7.txt");

        Permutation p = new Permutation();
        p.permute(Arrays.asList(0, 1, 2, 3, 4), 0);
        p.getPermutations();


        int results = Integer.MIN_VALUE;
        for (List item : p.getPermutations()) {
            int[] array = item.stream().mapToInt(i -> (int) i).toArray();
            //results = Math.max(results, calculatePartOne(ints, array));
        }

        System.out.println("answer is " + results);

// --------------- PART TWO ----------------------//

        p.permute(Arrays.asList(5,6,7,8,9),0);
        p.getPermutations();
        SolutionDay7 partTwoSolution = new SolutionDay7();
        partTwoSolution.setArray(ints);
        int output2 = 0;


        for (List item : p.getPermutations()) {
            //int[] array = item.stream().mapToInt(i -> (int) i).toArray();
            int[] array = new int[]{ 9,8,7,6,5 };
            results = Math.max(results, calculatePartTwo(partTwoSolution,ints, array));
        }
        System.out.println("answer is " + results);



    }


    private static int calculatePartOne(int[] input, int[] phaseSequence) {
        int output = 0;
        for (int i = 0; i < phaseSequence.length; i++) {
            SolutionDay7 k = new SolutionDay7();
            k.setArray(input);
            output = k.execute(new int[]{phaseSequence[i], output});

        }
        //System.out.println(output);
        return output;
    }

    private static int calculatePartTwo(SolutionDay7 solution, int[] input, int[] phaseSequence) {
        int output = 0;
        for (int i = 0; i < phaseSequence.length; i++) {
            //int[] ints = solution.executeWithState(new int[]{phaseSequence[i], output});
           // solution.setArray(ints);
        }
        System.out.println(output);
        return output;
    }


}




