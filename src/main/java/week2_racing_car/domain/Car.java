package week2_racing_car.domain;

public class Car {
    private final String name;
    private int distance;

    public Car(String name, int distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance(int moveDistance) {
        this.distance += moveDistance;
    }
}
