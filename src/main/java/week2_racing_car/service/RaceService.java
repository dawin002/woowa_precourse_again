package week2_racing_car.service;

import week2_racing_car.domain.Car;
import week2_racing_car.dto.CarResult;
import week2_racing_car.dto.SingleRaceResult;
import week2_racing_car.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceService {
    private final static int DEFAULT_DISTANCE = 0;
    private List<Car> cars;

    public RaceService() {
        this.cars = new ArrayList<>();
    }

    public void setCars(List<String> carNames) {
        validateCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName, DEFAULT_DISTANCE));
        }
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (Collections.frequency(carNames, carName) != 1) {
                throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
            }
        }
    }

    public void raceOneRound() {
        for (Car car : cars) {
            if (isCarMovable(createRaceNumber())) {
                car.increaseDistance(1);
            }
        }
    }

    private boolean isCarMovable(int number) {
        return number >= 4;
    }

    private int createRaceNumber() {
        return RandomNumberGenerator.createNumberInRange(0, 9);
    }

    public SingleRaceResult getResult() {
        SingleRaceResult raceResult = new SingleRaceResult();
        for (Car car : cars) {
            CarResult carResult = new CarResult(car.getName(), car.getDistance());
            raceResult.addSingleCar(carResult);
        }
        return raceResult;
    }

    public Object getWinners() {
        return null;
    }
}
