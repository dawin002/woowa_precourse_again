package week2_racing_car.controller;

import week2_racing_car.domain.RaceCounter;
import week2_racing_car.service.RaceService;
import week2_racing_car.view.InputView;
import week2_racing_car.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceService raceService;

    public RacingController(InputView inputView, OutputView outputView, RaceService raceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceService = raceService;
    }

    public void startRace() {
        raceService.setCars(inputCars());
        RaceCounter raceCounter = inputTryCount();
        while (raceCounter.isRemain()) {
            raceService.raceOneRound();
            outputView.printRaceResult(raceService.getResult());
            raceCounter.decrease();
        }
        outputView.printWinnerResult(raceService.getWinners());
    }

    private List<String> inputCars() {
        return null;
    }

    private RaceCounter inputTryCount() {
        return new RaceCounter();
    }
}
