package d02;

import java.util.Arrays;

public class Solution {

    private static final int ADD_CODE = 1;
    private static final int MULTIPLICATION_CODE = 2;
    private static final int HALT_CODE = 99;
    private static final int STEPPING_FORWARD_VALUE = 4;

    private int array[];

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
       System.out.println( Arrays.toString(array));
       System.out.println("-------------------------------------------");
    }
}
