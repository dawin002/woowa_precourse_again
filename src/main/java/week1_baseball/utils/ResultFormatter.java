package week1_baseball.utils;

import week1_baseball.dto.BaseballGameResult;

import static week1_baseball.message.ErrorMessage.NO_MATCH_RESULT_ERROR;
import static week1_baseball.message.ErrorMessage.RESULT_ERROR_TITLE;
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
        throw new IllegalStateException(RESULT_ERROR_TITLE.getTitle() +
                NO_MATCH_RESULT_ERROR.getMessage());
    }

    private static String getNothingMessage() {
        return NOTHING.getMessage();
    }

    private static String getStrikeAndBallMessage(BaseballGameResult gameResult) {
        return gameResult.getBall() +
                BALL.getMessage() +
                SPACE.getMessage() +
                gameResult.getStrike() +
                STRIKE.getMessage();
    }

    private static String getOnlyStrikeMessage(BaseballGameResult gameResult) {
        return gameResult.getStrike() + STRIKE.getMessage();
    }

    private static String getOnlyBallMessage(BaseballGameResult gameResult) {
        return gameResult.getBall() + BALL.getMessage();
    }
}
