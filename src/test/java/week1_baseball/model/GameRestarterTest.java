package week1_baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static week1_baseball.message.ErrorMessage.RESTART_ERROR_TITLE;
import static week1_baseball.message.ErrorMessage.WRONG_RESTART_NUMBER_ERROR;

class GameRestarterTest {

    @DisplayName("입력된 재시작 숫자가 1 또는 2가 아니라면 예외 처리")
    @ValueSource(ints = {0, 3, 10, -1, -2})
    @ParameterizedTest
    void validateRestartNumberIs1Or2(int restartNumber) {
        // given

        // when then
        assertThatThrownBy(() -> new GameRestarter(restartNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RESTART_ERROR_TITLE.getTitle() + WRONG_RESTART_NUMBER_ERROR.getMessage());
    }

    @DisplayName("입력된 재시작 숫자가 1이라면 true 반환")
    @Test
    void returnTrueWhenRestartNumberIs1() {
        // given
        int restartNumber = 1;

        // when
        GameRestarter restarter = new GameRestarter(restartNumber);

        // then
        assertThat(restarter.isRestart()).isTrue();
    }

    @DisplayName("입력된 재시작 숫자가 2라면 false 반환")
    @Test
    void returnFalseWhenRestartNumberIs2() {
        // given
        int restartNumber = 2;

        // when
        GameRestarter restarter = new GameRestarter(restartNumber);

        // then
        assertThat(restarter.isRestart()).isFalse();
    }

}