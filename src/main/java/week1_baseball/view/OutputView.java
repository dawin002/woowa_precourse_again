package week1_baseball.view;

import static week1_baseball.message.OutputMessage.GAME_END_MESSAGE;
import static week1_baseball.message.OutputMessage.GAME_START_MESSAGE;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printGameResult(String resultMessage) {
        System.out.println(resultMessage);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE.getMessage());
    }
}
