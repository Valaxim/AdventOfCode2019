package d10;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AsteroidsDetection {

    private final static char ASTEROIDS = '#';
    private static DecimalFormat df2 = new DecimalFormat("#.###");
    private static final int NUMBER_OF_PLANETS_TO_DESTROY = 200;

    public AsteroidsDetection() {
        df2.setPositivePrefix("+");
    }

    private List<MonitoringStation> monitoringStationList;

    public void run(char[][] input) {
        print2DArray(input);
        initializeMonitoringStations(input);
        calculateDirectionalCoefficients(monitoringStationList);

        int answerPart1 = monitoringStationList.stream().mapToInt(it -> it.getAngles().size()).max().orElse(0);
        System.out.println("Day 10 Part 1 answer is: " + answerPart1);

        MonitoringStation stationWithLaser = monitoringStationList.stream().filter(it -> it.getAngles().size() == answerPart1).findFirst().orElse(null);
        if (stationWithLaser != null) {
            input[stationWithLaser.getY()][stationWithLaser.getX()] = 'X';
            System.out.println("Station with laser X: " + stationWithLaser.getX() + ", Y: " + stationWithLaser.getY());
        }

        print2DArray(input);
        calculateRotation(stationWithLaser);
        monitoringStationList.remove(stationWithLaser);

        List<MonitoringStation> collect = monitoringStationList.stream()
                .sorted(Comparator.comparingDouble(MonitoringStation::getRotationFromCenter))
                .collect(Collectors.toList());

        int removed = 0;
        int currectPosition = 0;
        MonitoringStation lastRemoved = null;
        while (removed < NUMBER_OF_PLANETS_TO_DESTROY) {
            if (currectPosition > collect.size()) {
                currectPosition = 0;
            }
            double rotationFromCenter = collect.get(currectPosition).getRotationFromCenter();
            long count = collect.stream().filter(it -> it.getRotationFromCenter() == rotationFromCenter).count();
            lastRemoved = collect.stream().filter((it -> it.getRotationFromCenter() == rotationFromCenter)).min(Comparator.comparingDouble(MonitoringStation::getDistanceFromCenter)).get();
            collect.remove(lastRemoved);
            currectPosition += count - 1;
            removed++;
        }
        System.out.println(NUMBER_OF_PLANETS_TO_DESTROY + "th destoyed planet was: X: " + lastRemoved.getX() + ", Y: " + lastRemoved.getY());
        System.out.println(lastRemoved.getX() * 100 + lastRemoved.getY());
    }

    private void calculateRotation(MonitoringStation stationWithLaser) {
        for (MonitoringStation monitoringStation : monitoringStationList) {
            if (monitoringStation != stationWithLaser) {
                monitoringStation.setRotationFromCenter(calculateAngle(stationWithLaser.getX(), stationWithLaser.getY(), monitoringStation.getX(), monitoringStation.getY()));
                int distance = Math.abs(stationWithLaser.getX() - monitoringStation.getX()) + Math.abs(stationWithLaser.getY() - monitoringStation.getY());
                //System.out.println("Angle are: " + monitoringStation.getRotationFromCenter() + ", X: " + monitoringStation.getX() + ", Y: " + monitoringStation.getY() + ", distance: " + distance);
                monitoringStation.setDistanceFromCenter(distance);
            }
        }
    }

    public static double calculateAngle(double x1, double y1, double x2, double y2) {
        double angle = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        angle += 90;
        angle = angle + Math.ceil(-angle / 360) * 360;
        return angle;
    }

    private void calculateDirectionalCoefficients(List<MonitoringStation> monitoringStationList) {
        for (MonitoringStation station : monitoringStationList) {
            for (MonitoringStation analyzedStation : monitoringStationList) {
                if (station != analyzedStation) {
                    station.getAngles().add(String.valueOf(calculateAngle(analyzedStation.getX(), analyzedStation.getY(), station.getX(), station.getY())));
                }
            }
        }
    }

    private void initializeMonitoringStations(char[][] input) {
        monitoringStationList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == ASTEROIDS) {
                    monitoringStationList.add(new MonitoringStation(j, i));
                }
            }
        }
    }

    public void print2DArray(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (Character ch : input[i]) {
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }

    public List<MonitoringStation> getMonitoringStationList() {
        return monitoringStationList;
    }

    public void setMonitoringStationList(List<MonitoringStation> monitoringStationList) {
        this.monitoringStationList = monitoringStationList;
    }
}
