package d02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2 {

    public static final int EXPECTED_RESULT = 19690720;

    public static void main(String[] args) throws IOException {
        int[] ints = readInput();
        executePart1(ints);
        executePart2();

    }

    private static void executePart1(int[] ints) {
        Solution k = new Solution();
        k.setArray(ints);
        k.replaceArrayValue();
        int execute = k.execute();
        System.out.println("Answer Day2 part 1: " + execute);
    }

    private static void executePart2() throws IOException {
        Solution k2;
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                k2 = new Solution();
                int[] input = readInput();
                k2.setArray(input);
                k2.replaceArrayValue(noun, verb);
                if (EXPECTED_RESULT == k2.execute()) {
                    System.out.println("Answer Day2 part 2: " + (noun * 100 + verb));
                    System.out.println("i: " + noun + " j: " + verb);
                    return;
                }
            }
        }
    }

    private static int[] readInput() throws IOException {
        File file = new File("C:\\Users\\adamg\\Desktop\\Projects\\AdventOfCode2019\\src\\main\\resources\\inputDay2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        int[] arrays = new int[0];
        while ((st = br.readLine()) != null) {
            String[] split = st.split(",");
            arrays = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        }
        return arrays;
    }
}

