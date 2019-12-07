package d05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day5 {

    public static final int INPUT_PART_ONE = 1;
    public static final int INPUT_PART_TWO = 5;

    public static void main(String[] args) throws IOException {
        int[] ints = readInput();
        calculatePartOne(ints);
        ints = readInput();
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

    private static void calculatePart7(int[] ints) {

        Solution k = new Solution();
        k.setArray(ints);
        k.execute(4);
    }

    private static int[] readInput() throws IOException {
        File file = new File("C:\\Users\\adamg\\Desktop\\Projects\\AdventOfCode2019\\src\\main\\resources\\inputDay5.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int[] arrays = new int[0];
        while ((st = br.readLine()) != null) {
            String[] split = st.split(",");
            arrays = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
        }
        return arrays;
    }
}

