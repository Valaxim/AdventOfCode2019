package d07;

import d05.SolutionDay5;

public class SolutionDay7 extends SolutionDay5 {


    public int execute(int[] input) {
        boolean firstUse = true;
        int output = 0;
        int i = 0;

        while (array[i] != HALT_CODE) {
            int[] parseArray;
            //System.out.println("I : " + i + "Array[i]: " + array[i]);
            parseArray = parse(array[i]);
            if (parseArray[parseArray.length - 1] == ADD_CODE) {
                executeSum(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == MULTIPLICATION_CODE) {
                executeMultiply(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == READ_INPUT) {
                firstUse = executeRead(i, input, firstUse);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == WRITE_OUTPUT) {
                output = executeWrite(i);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == JUMP_IF_TRUE) {
                int k = jumpIfTrue(i, parseArray);
                i = movePointerPosition(i, k);
            } else if (parseArray[parseArray.length - 1] == JUMP_IF_FALSE) {
                int k = jumpIfFalse(i, parseArray);
                i = movePointerPosition(i, k);
            } else if (parseArray[parseArray.length - 1] == LESS_THAN) {
                lessThan(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == EQUALS) {
                executeEquals(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            }
        }
        return output;
    }

    public int[] executeWithState(int[] input, int[] phase) {
        boolean firstUse = true;
        int output = 0;
        int i = 0;

        while (array[i] != HALT_CODE) {
            int[] parseArray;
            //System.out.println("I : " + i + "Array[i]: " + array[i]);
            parseArray = parse(array[i]);
            if (parseArray[parseArray.length - 1] == ADD_CODE) {
                executeSum(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == MULTIPLICATION_CODE) {
                executeMultiply(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == READ_INPUT) {
                firstUse = executeRead(i, input, firstUse);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == WRITE_OUTPUT) {
                output = executeWrite(i);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == JUMP_IF_TRUE) {
                int k = jumpIfTrue(i, parseArray);
                i = movePointerPosition(i, k);
            } else if (parseArray[parseArray.length - 1] == JUMP_IF_FALSE) {
                int k = jumpIfFalse(i, parseArray);
                i = movePointerPosition(i, k);
            } else if (parseArray[parseArray.length - 1] == LESS_THAN) {
                lessThan(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            } else if (parseArray[parseArray.length - 1] == EQUALS) {
                executeEquals(i, parseArray);
                i += STEPPING_FORWARD_VALUE;
            }
        }
        return array;
    }


    protected boolean executeRead(int i, int[] input, boolean firstUse) {
        array[array[i + 1]] = firstUse ? input[0] : input[1];
        return false;
    }

    protected int executeWrite(int i) {
       // System.out.println(array[array[i + 1]]);
        return array[array[i + 1]];

    }
}
