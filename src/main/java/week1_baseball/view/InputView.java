package week1_baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_PLAYER_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String READ_REPLAY_NUMBER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public String readPlayerNumbers() {
        System.out.print(READ_PLAYER_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String readReplayNumber() {
        System.out.println(READ_REPLAY_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
