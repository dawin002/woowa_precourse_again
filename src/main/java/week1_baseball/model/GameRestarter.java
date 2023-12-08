package week1_baseball.model;

import static week1_baseball.message.ErrorMessage.WRONG_RESTART_NUMBER_ERROR;

public class GameRestarter {
    private static final int GAME_RESTART_NUMBER = 1;
    private static final int GAME_END_NUMBER = 2;
    private final int restartNumber;

    public GameRestarter(int restartNumber) {
        validateNumber(restartNumber);
        this.restartNumber = restartNumber;
    }

    private void validateNumber(int number) {
        if (number != GAME_RESTART_NUMBER && number != GAME_END_NUMBER) {
            throw new IllegalArgumentException(WRONG_RESTART_NUMBER_ERROR.getRestartMessage());
        }
    }

    public boolean isRestart() {
        return restartNumber == GAME_RESTART_NUMBER;
    }
}
