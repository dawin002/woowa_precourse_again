package week1_baseball.dto;

public class BaseballGameResult {
    private final int strike;
    private final int ball;
    private final boolean isFullStrike;

    public BaseballGameResult(int strike, int ball, boolean isFullStrike) {
        this.strike = strike;
        this.ball = ball;
        this.isFullStrike = isFullStrike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFullStrike() {
        return isFullStrike;
    }
}
