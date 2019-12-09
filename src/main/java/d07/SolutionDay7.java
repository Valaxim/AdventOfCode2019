package d07;

import d05.SolutionDay5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDay7 extends SolutionDay5 {

    private int currentPosition;
    private boolean isHalted;
    private boolean firstUsed;
    private int output;

    public SolutionDay7() {
        this.firstUsed = true;
    }

    public int executeLoop(int[] input) {
        int i = currentPosition;
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
                setFirstUsed(executeRead(i, input, isFirstUsed()));
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
            } else if (parseArray[parseArray.length - 1] == WRITE_OUTPUT) {
                output = executeWrite(i);
                i += STEPPING_FORWARD_VALUE_READ_WRITE;
                setCurrentPosition(i);
                return output;
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
        setHalted(true);
        return output;
    }

    public boolean executeRead(int i, int[] input, boolean firstUse) {
        array[array[i + 1]] = firstUse ? input[0] : input[1];
        return false;
    }

    public int executeWrite(int i) {
        return array[array[i + 1]];
    }

    public int calculatePartOne(int[] input) {
        Permutation p = new Permutation();
        p.permute(Arrays.asList(0, 1, 2, 3, 4), 0);
        int output = 0;
        for (List item : p.getPermutations()) {
            int[] array = item.stream().mapToInt(i -> (int) i).toArray();
            output = Math.max(calculatePartOneForPhase(input, array), output);
        }
        return output;
    }

    public int calculatePartOneForPhase(int[] input, int[] phaseSequence) {
        int output = 0;
        for (int i = 0; i < phaseSequence.length; i++) {
            SolutionDay7 k = new SolutionDay7();
            k.setArray(input);
            output = k.executeLoop(new int[]{phaseSequence[i], output});
        }
        return output;
    }

    public int calculatePartTwo(int[] input) throws IOException {
        Permutation p = new Permutation();
        p.permute(Arrays.asList(5, 6, 7, 8, 9), 0);
        int maxThrustedSignal = 0;

        for (List<Integer> permutation : p.getPermutations()) {
            int ampOutput = 0;
            List<SolutionDay7> listAllAmplifier = initialize(input);

            while (!listAllAmplifier.get(listAllAmplifier.size() - 1).isHalted()) {
                for (int amplifierNumber = 0; amplifierNumber < listAllAmplifier.size(); amplifierNumber++) {
                    SolutionDay7 currentAmplifier = listAllAmplifier.get(amplifierNumber);
                    ampOutput = currentAmplifier.executeLoop(new int[]{permutation.get(amplifierNumber), ampOutput});
                }
            }
            maxThrustedSignal = Math.max(maxThrustedSignal, listAllAmplifier.get(listAllAmplifier.size() - 1).getOutput());
        }
        return maxThrustedSignal;
    }

    private List<SolutionDay7> initialize(int[] input) {
        List<SolutionDay7> listAmplifiers = new ArrayList<>();

        SolutionDay7 A = new SolutionDay7();
        A.setArray(input.clone());
        listAmplifiers.add(A);

        SolutionDay7 B = new SolutionDay7();
        B.setArray(input.clone());
        listAmplifiers.add(B);

        SolutionDay7 C = new SolutionDay7();
        C.setArray(input.clone());
        listAmplifiers.add(C);

        SolutionDay7 D = new SolutionDay7();
        D.setArray(input.clone());
        listAmplifiers.add(D);

        SolutionDay7 E = new SolutionDay7();
        E.setArray(input.clone());
        listAmplifiers.add(E);

        return listAmplifiers;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isHalted() {
        return isHalted;
    }

    public void setHalted(boolean halted) {
        isHalted = halted;
    }

    public boolean isFirstUsed() {
        return firstUsed;
    }

    public void setFirstUsed(boolean firstUsed) {
        this.firstUsed = firstUsed;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}


