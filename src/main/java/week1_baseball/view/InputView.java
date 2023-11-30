package week1_baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String MESSAGE_READ_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";
    public String readPlayerNumbers() {
        System.out.print(MESSAGE_READ_PLAYER_NUMBERS);
        return Console.readLine();
    }
}
