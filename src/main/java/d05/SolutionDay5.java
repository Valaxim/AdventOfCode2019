package d05;

import d02.Solution;

public class SolutionDay5 extends Solution {

    protected static final int READ_INPUT = 3;
    protected static final int WRITE_OUTPUT = 4;
    protected static final int JUMP_IF_TRUE = 5;
    protected static final int JUMP_IF_FALSE = 6;
    protected static final int LESS_THAN = 7;
    protected static final int EQUALS = 8;

    protected static final int STEPPING_FORWARD_VALUE_READ_WRITE = 2;
    protected static final int STEPPING_FORWARD_JUMP_CALL = 3;

    public int execute(int inputPartOne) {
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
                executeRead(i, inputPartOne);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == WRITE_OUTPUT) {
                executeWrite(i);
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
        return array[0];
    }

    protected int movePointerPosition(int i, int k) {
        return (k != i) ? k : i + STEPPING_FORWARD_JUMP_CALL;
    }


    protected void executeEquals(int i, int[] parseArray) {
        int[] controlBits = getControlBits(parseArray);
        array[array[i + 3]] = readParam(controlBits[0], i + 1) == readParam(controlBits[1], i + 2) ? 1 : 0;
    }

    protected void lessThan(int i, int[] parseArray) {
        int[] controlBits = getControlBits(parseArray);
        array[array[i + 3]] = readParam(controlBits[0], i + 1) < readParam(controlBits[1], i + 2) ? 1 : 0;
    }

    protected int jumpIfFalse(int i, int[] parseArray) {
        int[] controlBits = getControlBits(parseArray);
        if (readParam(controlBits[0], i + 1) == 0) {
            return readParam(controlBits[1], i + 2);
        }
        return i;
    }

    protected int jumpIfTrue(int i1, int[] parseArray) {
        int[] controlBits = getControlBits(parseArray);
        if (readParam(controlBits[0], i1 + 1) != 0) {
            return readParam(controlBits[1], i1 + 2);
        }
        return i1;
    }

    protected int[] parse(int num) {
        return Integer.toString(num).chars().map(c -> c - '0').toArray();
    }

    protected int executeWrite(int i) {
        System.out.println(array[array[i + 1]]);
        return i;
    }

    protected void executeRead(int i, int input) {
        array[array[i + 1]] = input;
    }

    protected void executeMultiply(int j, int[] i) {
        int[] controlBits = getControlBits(i);
        array[array[j + 3]] = readParam(controlBits[0], j + 1) * readParam(controlBits[1], j + 2);
    }

    protected void executeSum(int j, int[] i) {
        int[] controlBits = getControlBits(i);
        array[array[j + 3]] = readParam(controlBits[0], j + 1) + readParam(controlBits[1], j + 2);
    }

    protected int[] getControlBits(int[] array) {
        int param1 = 0, param2 = 0;
        if (array.length == 3) {
            param1 = 1;
        } else if (array.length > 3) {
            param1 = array[1];
            param2 = 1;
        }
        return new int[]{param1, param2};
    }

    protected int readParam(int param, int position) {
        return param == 0 ? array[array[position]] : array[position];
    }

}
