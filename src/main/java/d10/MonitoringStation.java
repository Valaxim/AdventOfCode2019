package d10;

import java.util.HashSet;
import java.util.Set;

public class MonitoringStation {

    private int x;
    private int y;
    private Set<String> angles;
    private double rotationFromCenter;
    private double distanceFromCenter;

    public MonitoringStation(int x, int y) {
        this.x = x;
        this.y = y;
        this.angles = new HashSet<>();
        this.rotationFromCenter = 0;
        this.distanceFromCenter = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRotationFromCenter() {
        return rotationFromCenter;
    }

    public void setRotationFromCenter(double rotationFromCenter) {
        this.rotationFromCenter = rotationFromCenter;
    }

    public double getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(double distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public Set<String> getAngles() {
        return angles;
    }

    public void setAngles(Set<String> angles) {
        this.angles = angles;
    }
}
