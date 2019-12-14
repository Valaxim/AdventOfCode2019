package d12;

import java.util.ArrayList;
import java.util.List;

public class SolutionDay12 {

    public static final int STEPS = 1000;

        public void runPart1() {
            List<Planet> planets = readInput();

            for (int i = 0; i < STEPS; i++) {
                changeVelocity(planets);
                changePosition(planets);
            }

            int result = 0;
            for (Planet p : planets) {
                result += p.calculateTotalEnergy();
            }
            System.out.println("answer is " + result);
        }

    public void runPartX() {
        List<Planet> planets = readInput();
        List<Planet> clonedList = readInput();
        long step = 0;
        do {
            changeVelocityX(planets);
            changePosition(planets);
            step++;
        } while (!planets.equals(clonedList));

        System.out.println("Answer2 for X: " + step);
    }

    public void runPartY() {
        List<Planet> planets = readInput();
        List<Planet> clonedList = readInput();
        long step = 0;
        do {
            changeVelocityY(planets);
            changePosition(planets);
            step++;
        } while (!planets.equals(clonedList));

        System.out.println("Answer2 for Y: " + step);
    }

    public void runPartZ() {
        List<Planet> planets = readInput();
        List<Planet> clonedList = readInput();
        long step = 0;
        do {
            changeVelocityZ(planets);
            changePosition(planets);
            step++;
        } while (!planets.equals(clonedList));

        System.out.println("Answer2 for Z: " + step);
    }

    private static void changePosition(List<Planet> planetList) {
        for (Planet sourcePlanet : planetList) {
            move(sourcePlanet);
        }
    }


    private static void changeVelocity(List<Planet> planetList) {
        for (Planet sourcePlanet : planetList) {
            for (Planet destinationPlanet : planetList) {
                if (sourcePlanet != destinationPlanet) {
                    calculateVelocityForPlanet(sourcePlanet, destinationPlanet);
                }
            }
        }
    }

    private static void changeVelocityX(List<Planet> planetList) {
        for (Planet sourcePlanet : planetList) {
            for (Planet destinationPlanet : planetList) {
                if (sourcePlanet != destinationPlanet) {
                    calculateX(sourcePlanet, destinationPlanet);
                }
            }
        }
    }

    private static void changeVelocityY(List<Planet> planetList) {
        for (Planet sourcePlanet : planetList) {
            for (Planet destinationPlanet : planetList) {
                if (sourcePlanet != destinationPlanet) {
                    calculateY(sourcePlanet, destinationPlanet);
                }
            }
        }
    }

    private static void changeVelocityZ(List<Planet> planetList) {
        for (Planet sourcePlanet : planetList) {
            for (Planet destinationPlanet : planetList) {
                if (sourcePlanet != destinationPlanet) {
                    calculateZ(sourcePlanet, destinationPlanet);
                }
            }
        }
    }

    private static void move(Planet sourcePlanet) {
        moveX(sourcePlanet);
        moveY(sourcePlanet);
        moveZ(sourcePlanet);
    }

    private static void moveX(Planet sourcePlanet) {
        sourcePlanet.addPosition_x(sourcePlanet.getVelocity_x());
    }

    private static void moveY(Planet sourcePlanet) {
        sourcePlanet.addPosition_y(sourcePlanet.getVelocity_y());
    }

    private static void moveZ(Planet sourcePlanet) {
        sourcePlanet.addPosition_z(sourcePlanet.getVelocity_z());
    }

    private static void calculateVelocityForPlanet(Planet sourcePlanet, Planet destinationPlanet) {
        calculateX(sourcePlanet, destinationPlanet);
        calculateY(sourcePlanet, destinationPlanet);
        calculateZ(sourcePlanet, destinationPlanet);
    }

    private static void calculateX(Planet sourcePlanet, Planet destinationPlanet) {
        destinationPlanet.addVelocity_x(destinationPlanet.getPosition_x().compareTo(sourcePlanet.getPosition_x()));
    }

    private static void calculateY(Planet sourcePlanet, Planet destinationPlanet) {
        destinationPlanet.addVelocity_y(destinationPlanet.getPosition_y().compareTo(sourcePlanet.getPosition_y()));
    }

    private static void calculateZ(Planet sourcePlanet, Planet destinationPlanet) {
        destinationPlanet.addVelocity_z(destinationPlanet.getPosition_z().compareTo(sourcePlanet.getPosition_z()));
    }


    private List<Planet> readInput() {
        Planet A = new Planet(16, -8, 13);
        Planet B = new Planet(4, 10, 10);
        Planet C = new Planet(17, -5, 6);
        Planet D = new Planet(13, -3, 0);

        List<Planet> planetList = new ArrayList<>();
        planetList.add(A);
        planetList.add(B);
        planetList.add(C);
        planetList.add(D);
        return planetList;
    }
}
