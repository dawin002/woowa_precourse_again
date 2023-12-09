package week2_racing_car.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleRaceResult {
    List<CarResult> carResults;

    public SingleRaceResult() {
        this.carResults = new ArrayList<>();
    }

    public void addSingleCar(CarResult carResult) {
        this.carResults.add(carResult);
    }

    public List<CarResult> getResults() {
        return Collections.unmodifiableList(carResults);
    }
}
