package d04;

import java.util.Arrays;

public class SolutionDay4 {

    public  boolean validatePair(int number) {
        String strNumber = String.valueOf(number);
        char[] digits = strNumber.toCharArray();
        return digits[0] == digits[1] || digits[2] == digits[1] || digits[2] == digits[3] || digits[3] == digits[4] || digits[4] == digits[5];
    }

    public  boolean validateIncreasing(int number) {
        String strNumber = String.valueOf(number);
        char[] digits = strNumber.toCharArray();
        return digits[0] <= digits[1] && digits[1] <= digits[2] && digits[2] <= digits[3] && digits[3] <= digits[4] && digits[4] <= digits[5];
    }

    public  boolean validateGroup(int number) {
        int[] intTab = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
        int[] digits = new int[10];
        for (int i: intTab) {
            digits[i] = digits[i]+1;
        }
        Arrays.sort(digits);
        return digits[9] <= 2 || digits[8] == 2;

    }
}
