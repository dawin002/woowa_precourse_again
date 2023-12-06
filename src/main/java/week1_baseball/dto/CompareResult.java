package week1_baseball.dto;

public class CompareResult {
    private final int strike;
    private final int ball;

    public CompareResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
