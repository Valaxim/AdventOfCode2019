package d02;

import utils.ParseUtil;

import java.io.IOException;
import java.util.Arrays;

public class Solution {

    private static final int EXPECTED_RESULT = 19690720;

    protected static final int ADD_CODE = 1;
    protected static final int MULTIPLICATION_CODE = 2;
    protected static final int HALT_CODE = 99;
    protected static final int STEPPING_FORWARD_VALUE = 4;

    protected int array[];

    public void executePart1(int[] ints) {
        setArray(ints);
        replaceArrayValue();
        int execute = execute();
        System.out.println("Answer Day2 part 1: " + execute);
    }


    public void executePart2() throws IOException {
        Solution k2;
        ParseUtil parser = new ParseUtil();
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                k2 = new Solution();
                int[] integers = parser.readInputContainsIntegers("inputDay2.txt");
                k2.setArray(integers);
                k2.replaceArrayValue(noun, verb);
                if (EXPECTED_RESULT == k2.execute()) {
                    System.out.println("Answer Day2 part 2: " + (noun * 100 + verb));
                    System.out.println("i: " + noun + " j: " + verb);
                    return;
                }
            }
        }
    }

    public int execute() {
        int i = 0;
        while (array[i] != HALT_CODE) {
            if (array[i] == ADD_CODE) {
                executeSum(i);
            } else if (array[i] == MULTIPLICATION_CODE) {
                executeMultiply(i);
            }
            i += STEPPING_FORWARD_VALUE;
        }
        int i1 = array[0];
        return i1;
    }

    private void executeMultiply(int i) {
        array[array[i + 3]] = array[array[i + 2]] * array[array[i + 1]];
    }

    private void executeSum(int i) {
        array[array[i + 3]] = array[array[i + 2]] + array[array[i + 1]];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void replaceArrayValue() {
        this.array[1] = 12;
        this.array[2] = 2;
    }

    public void replaceArrayValue(int a, int b) {
        this.array[1] = a;
        this.array[2] = b;
    }

    public void printArray() {
        System.out.println("------------------ ARRAY ------------------");
        System.out.println(Arrays.toString(array));
        System.out.println("-------------------------------------------");
    }
}
