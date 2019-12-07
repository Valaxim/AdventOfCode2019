package d04;

import java.util.Arrays;

public class Day4 {

    private static final int MIN = 264793;
    private static final int MAX = 803935;

    public static void main(String[] argv) {

        int sum = 0;
        for (int i = MIN; i <= MAX; i++) {
            if (validatePair(i) && validateIncreasing(i))
                sum++;
        }
        System.out.println("Solution part1: " + sum);

        int sum2= 0;
        for (int i = MIN; i <= MAX; i++) {
            if (validatePair(i) && validateIncreasing(i) && validateGroup(i)) {
                sum2++;
            }
        }
        System.out.println("Solution part2: " + sum2);
    }

    public static boolean validatePair(int number) {
        String strNumber = String.valueOf(number);
        char[] digits = strNumber.toCharArray();
        return digits[0] == digits[1] || digits[2] == digits[1] || digits[2] == digits[3] || digits[3] == digits[4] || digits[4] == digits[5];
    }

    public static boolean validateIncreasing(int number) {
        String strNumber = String.valueOf(number);
        char[] digits = strNumber.toCharArray();
        return digits[0] <= digits[1] && digits[1] <= digits[2] && digits[2] <= digits[3] && digits[3] <= digits[4] && digits[4] <= digits[5];
    }

    public static boolean validateGroup(int number) {
        int[] intTab = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
        int[] digits = new int[10];
        for (int i: intTab) {
            digits[i] = digits[i]+1;
        }
        Arrays.sort(digits);
        return digits[9] <= 2 || digits[8] == 2;

    }
}