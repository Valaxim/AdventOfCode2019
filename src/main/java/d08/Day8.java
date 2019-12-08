package d08;

import utils.ParseUtil;

import java.io.IOException;
import java.util.Arrays;

public class Day8 {

    private final static int WIDE = 25;
    private final static int TALL = 6;

    public static void main(String[] args) throws IOException {
        ParseUtil parser = new ParseUtil();
        int[] input = parser.readFileWithoutDelimeter("inputDay8.txt");

        int numberOfLayer = input.length / (WIDE * TALL);
        calculatePartOne(input, numberOfLayer);

        int[] ints = calculatePartTwo(input, numberOfLayer);
        printLayer(ints);
    }

    private static void printLayer(int[] ints) {
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

    private static int[] calculatePartTwo(int[] input, int numberOfLayer) {
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

    private static void calculatePartOne(int[] input, int numberOfLayer) {
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
                System.out.println("Answer part one= " + sumOnes[i] * sumTwo[i]);
            }
        }
    }
}
