package d07;

import d05.Day5;
import utils.ParseUtil;

import java.io.IOException;

public class Day7 extends Day5 {

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        int[] ints = parser.readInputContainsIntegers("inputDay7.txt");

        SolutionDay7 solutionDay7 = new SolutionDay7();
        int results = solutionDay7.calculatePartOne(ints);

        System.out.println("Part1 answer is: " + results);

        SolutionDay7 solutionDay7part2 = new SolutionDay7();
        int results2 = solutionDay7part2.calculatePartTwo(ints);

        System.out.println("Part2 answer is: " + results2);

    }
}




