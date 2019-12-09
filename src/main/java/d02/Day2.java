package d02;

import utils.ParseUtil;

import java.io.IOException;

public class Day2 {

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        int[] ints = parser.readInputContainsIntegers("inputDay2.txt");
        Solution solution = new Solution();
        solution.executePart1(ints);
        solution.executePart2();

    }
}

