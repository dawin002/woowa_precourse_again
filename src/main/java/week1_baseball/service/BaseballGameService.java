package week1_baseball.service;

import week1_baseball.dto.BaseballGameResult;
import week1_baseball.model.ComputerNumbers;
import week1_baseball.model.PlayerNumbers;

import java.util.List;

import static week1_baseball.model.NumberInfo.NUMBERS_SIZE;

public class BaseballGameService {
    private ComputerNumbers computerNumbers;
    private PlayerNumbers playerNumbers;

    public void setComputerNumbers(List<Integer> numbers) {
        this.computerNumbers = new ComputerNumbers(numbers);
    }

    public void setPlayerNumbers(List<Integer> numbers) {
        this.playerNumbers = new PlayerNumbers(numbers);
    }

    public BaseballGameResult calculateResult() {
        List<Integer> computer = computerNumbers.getNumbers();
        List<Integer> player = playerNumbers.getNumbers();
        int strike = countStrike(computer, player);
        int ball = countBall(computer, player);
        return new BaseballGameResult(strike, ball, isFullStrike(strike));
    }

    private int countStrike(List<Integer> computer, List<Integer> player) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBERS_SIZE.getNumber(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;
        for (int i = 0; i < NUMBERS_SIZE.getNumber(); i++) {
            if (computer.contains(player.get(i))
                    && !computer.get(i).equals(player.get(i))) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isFullStrike(int strike) {
        return strike == NUMBERS_SIZE.getNumber();
    }
}
