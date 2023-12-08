package week1_baseball.controller;

import week1_baseball.dto.BaseballGameResult;
import week1_baseball.model.GameRestarter;
import week1_baseball.service.BaseballGameService;
import week1_baseball.utils.NumberGenerator;
import week1_baseball.utils.InputParser;
import week1_baseball.utils.ResultFormatter;
import week1_baseball.view.InputView;
import week1_baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    InputView inputView;
    OutputView outputView;
    BaseballGameService gameService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballGameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void startGame() {
        outputView.printGameStartMessage();
        gameService.setComputerNumbers(NumberGenerator.createUniqueNumbers());
        while (true) {
            gameService.setPlayerNumbers(inputPlayerNumbers());
            BaseballGameResult gameResult = gameService.calculateResult();
            outputView.printGameResult(ResultFormatter.createResultMessage(gameResult));
            if (gameResult.isFullStrike()) {
                break;
            }
        }
        outputView.printGameEndMessage();
    }

    private List<Integer> inputPlayerNumbers() {
        String input = inputView.readPlayerNumbers();
        return InputParser.stringToIntList(input);
    }

    public boolean checkRestart() {
        GameRestarter gameRestarter = new GameRestarter(inputRestartNumber());
        return gameRestarter.isRestart();
    }

    private int inputRestartNumber() {
        String input = inputView.readRestartNumber();
        return InputParser.stringToInt(input);
    }

}
