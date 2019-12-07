package d01;

public class Rocket {

    public int calculateFuel(int weight) {
        return weight / 3 - 2;
    }

    public int extendedCalculateFuel(int weight) {
        int sum = 0;
        while (calculateFuel(weight) > 0) {
            weight = calculateFuel(weight);
            sum += weight;
        }
        return sum;
    }
}
