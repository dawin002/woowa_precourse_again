package week2_racing_car.dto;

public class CarResult {
    private final String name;
    private final int distance;

    public CarResult(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
