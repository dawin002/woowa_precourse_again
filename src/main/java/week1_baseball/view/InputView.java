package week1_baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static week1_baseball.message.InputMessage.READ_PLAYER_NUMBERS_MESSAGE;
import static week1_baseball.message.InputMessage.READ_REPLAY_NUMBER_MESSAGE;

public class InputView {

    public String readPlayerNumbers() {
        System.out.print(READ_PLAYER_NUMBERS_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String readReplayNumber() {
        System.out.println(READ_REPLAY_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }
}
