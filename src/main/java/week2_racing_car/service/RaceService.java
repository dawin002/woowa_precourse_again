package week2_racing_car.service;

import week2_racing_car.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceService {
    private final static int INITIAL_DISTANCE = 0;
    private List<Car> cars;

    public RaceService() {
        this.cars = new ArrayList<>();
    }

    public void setCars(List<String> carNames) {
        validateCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName, INITIAL_DISTANCE));
        }
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (Collections.frequency(carNames, carName) != 1) {
                throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
            }
        }
    }


}
