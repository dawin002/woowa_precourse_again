package week1_baseball;

import week1_baseball.controller.BaseballController;
import week1_baseball.service.BaseballGameService;
import week1_baseball.view.InputView;
import week1_baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballGameService gameService = new BaseballGameService();

        BaseballController baseballController = new BaseballController(inputView, outputView, gameService);
        baseballController.startGame();
    }
}
