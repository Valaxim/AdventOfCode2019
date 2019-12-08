package d05;

import utils.ParseUtil;

import java.io.IOException;

public class Day5 {

    private static final int INPUT_PART_ONE = 1;
    private static final int INPUT_PART_TWO = 5;

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        int[] ints = parser.readInputContainsIntegers("inputDay5.txt");
        calculatePartOne(ints);
        ints = parser.readInputContainsIntegers("inputDay5.txt");
        calculatePartTwo(ints);
    }

    private static void calculatePartOne(int[] ints) {
        Solution k = new Solution();
        k.setArray(ints);
        k.execute(INPUT_PART_ONE);
    }

    private static void calculatePartTwo(int[] ints) {
        Solution k = new Solution();
        k.setArray(ints);
        k.execute(INPUT_PART_TWO);
    }

}

