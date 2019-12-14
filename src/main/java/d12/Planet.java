package d12;

import java.util.Objects;

public class Planet {

    private Integer position_x;
    private Integer position_y;
    private Integer position_z;

    private Integer velocity_x;
    private Integer velocity_y;
    private Integer velocity_z;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Planet(Integer position_x, Integer position_y, Integer position_z) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.position_z = position_z;
        this.velocity_x = 0;
        this.velocity_y = 0;
        this.velocity_z = 0;
    }

    public Integer calculateTotalEnergy() {
        return calculatePotentialEnergy() * calculateKineticEnergy();
    }

    private Integer calculatePotentialEnergy() {
        return Math.abs(position_x) + Math.abs(position_y) + Math.abs(position_z);
    }

    private Integer calculateKineticEnergy() {
        return Math.abs(velocity_x) + Math.abs(velocity_y) + Math.abs(velocity_z);
    }

    public Integer getPosition_x() {
        return position_x;
    }

    public void setPosition_x(Integer position_x) {
        this.position_x = position_x;
    }

    public Integer getPosition_y() {
        return position_y;
    }

    public void setPosition_y(Integer position_y) {
        this.position_y = position_y;
    }

    public Integer getPosition_z() {
        return position_z;
    }

    public void setPosition_z(Integer position_z) {
        this.position_z = position_z;
    }

    public Integer getVelocity_x() {
        return velocity_x;
    }

    public void setVelocity_x(Integer velocity_x) {
        this.velocity_x = velocity_x;
    }

    public Integer getVelocity_y() {
        return velocity_y;
    }

    public void setVelocity_y(Integer velocity_y) {
        this.velocity_y = velocity_y;
    }

    public Integer getVelocity_z() {
        return velocity_z;
    }

    public void setVelocity_z(Integer velocity_z) {
        this.velocity_z = velocity_z;
    }

    public void addVelocity_x(int velocity) {
        this.velocity_x -= velocity;
    }

    public void addVelocity_y(int velocity) {
        this.velocity_y -= velocity;
    }

    public void addVelocity_z(int velocity) {
        this.velocity_z -= velocity;
    }

    public void addPosition_x(int velocity) {
        this.position_x += velocity;
    }

    public void addPosition_y(int velocity) {
        this.position_y += velocity;
    }

    public void addPosition_z(int velocity) {
        this.position_z += velocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(position_x, planet.position_x) &&
                Objects.equals(position_y, planet.position_y) &&
                Objects.equals(position_z, planet.position_z) &&
                Objects.equals(velocity_x, planet.velocity_x) &&
                Objects.equals(velocity_y, planet.velocity_y) &&
                Objects.equals(velocity_z, planet.velocity_z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position_x, position_y, position_z, velocity_x, velocity_y, velocity_z);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "position_x=" + position_x +
                ", position_y=" + position_y +
                ", position_z=" + position_z +
                ", velocity_x=" + velocity_x +
                ", velocity_y=" + velocity_y +
                ", velocity_z=" + velocity_z +
                '}';
    }
}
