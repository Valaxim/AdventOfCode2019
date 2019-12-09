package d08;

import java.util.Arrays;

public class Layer {

    private final int WIDE = 25;
    private final int TALL = 6;

    public void printLayer(int[] ints) {
        for (int a = 0; a < ints.length; a++) {
            if (a % WIDE == 0) {
                System.out.println();
            }
            if (ints[a] != 0) {
                System.out.print(ints[a] + " ");
            } else {
                System.out.print("  ");
            }
        }
    }

    public int[] calculatePartTwo(int[] input) {
        int numberOfLayer = input.length / (WIDE * TALL);
        int[] image = new int[WIDE * TALL];
        for (int i = 0; i < WIDE * TALL; i++) {
            for (int j = 0; j < numberOfLayer; j++) {
                if (input[j * (WIDE*TALL) + i] != 2) {
                    image[i] = input[j * (WIDE*TALL) + i];
                    break;
                }
            }
        }
        return image;
    }

    public void calculatePartOne(int[] input) {
        int numberOfLayer = input.length / (WIDE * TALL);
        int[] sumZeros = new int[numberOfLayer];
        int[] sumOnes = new int[numberOfLayer];
        int[] sumTwo = new int[numberOfLayer];
        for (int i = 0; i < numberOfLayer; i++) {
            for (int j = 0; j < WIDE * TALL; j++) {
                if (input[i * (WIDE * TALL) + j] == 0)
                    sumZeros[i]++;

                if (input[i * (WIDE * TALL) + j] == 1)
                    sumOnes[i]++;

                if (input[i * (WIDE * TALL) + j] == 2)
                    sumTwo[i]++;
            }
        }

        int minZeros = Arrays.stream(sumZeros).min().orElse(0);
        for (int i = 0; i < numberOfLayer; i++) {
            if (sumZeros[i] == minZeros) {
                System.out.println("Layer with lowest zeros is layer: " + (i+1));
                System.out.println("Answer part one = " + sumOnes[i] * sumTwo[i]);
            }
        }
    }


}
