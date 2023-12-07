package week1_baseball.utils;

import week1_baseball.dto.BaseballGameResult;

import static week1_baseball.message.ErrorMessage.NO_MATCH_RESULT_ERROR;
import static week1_baseball.message.ResultMessage.*;

public class ResultFormatter {
    public static String createResultMessage(BaseballGameResult gameResult) {
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            return getNothingMessage();
        }
        if (gameResult.getStrike() != 0 && gameResult.getBall() != 0) {
            return getStrikeAndBallMessage(gameResult);
        }
        if (gameResult.getStrike() != 0 && gameResult.getBall() == 0) {
            return getOnlyStrikeMessage(gameResult);
        }
        if (gameResult.getStrike() == 0 && gameResult.getBall() != 0) {
            return getOnlyBallMessage(gameResult);
        }
        throw new IllegalStateException(NO_MATCH_RESULT_ERROR.getMessage());
    }

    private static String getNothingMessage() {
        return NOTHING.getMessage();
    }

    private static String getStrikeAndBallMessage(BaseballGameResult gameResult) {
        return new StringBuilder()
                .append(gameResult.getBall())
                .append(BALL.getMessage())
                .append(SPACE.getMessage())
                .append(gameResult.getStrike())
                .append(STRIKE.getMessage())
                .toString();
    }

    private static String getOnlyStrikeMessage(BaseballGameResult gameResult) {
        return new StringBuilder()
                .append(gameResult.getStrike())
                .append(STRIKE.getMessage())
                .toString();
    }

    private static String getOnlyBallMessage(BaseballGameResult gameResult) {
        return new StringBuilder()
                .append(gameResult.getBall())
                .append(BALL.getMessage())
                .toString();
    }
}
