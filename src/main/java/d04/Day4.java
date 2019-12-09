package d04;

public class Day4 {

    private static final int MIN = 264793;
    private static final int MAX = 803935;

    public static void main(String[] argv) {

        SolutionDay4 solutionDay4 = new SolutionDay4();

        int sum = 0;
        for (int i = MIN; i <= MAX; i++) {
            if (solutionDay4.validatePair(i) && solutionDay4.validateIncreasing(i))
                sum++;
        }
        System.out.println("Solution part1: " + sum);

        int sum2= 0;
        for (int i = MIN; i <= MAX; i++) {
            if (solutionDay4.validatePair(i) && solutionDay4.validateIncreasing(i) && solutionDay4.validateGroup(i)) {
                sum2++;
            }
        }
        System.out.println("Solution part2: " + sum2);
    }
}