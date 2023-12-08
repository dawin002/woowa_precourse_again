package week1_baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static week1_baseball.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNumbersTest {

    @DisplayName("전달된 정수 리스트로 플레이어 숫자 객체 초기화")
    @Test
    void setPlayerNumbersByGivenNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // when
        PlayerNumbers playerNumbers = new PlayerNumbers(numbers);

        // then
        for (int number : numbers) {
            assertThat(playerNumbers.getNumbers()).contains(number);
        }
    }

    @DisplayName("숫자가 3개가 아닌 경우 예외 처리")
    @Test
    void validateNumbersSize() {
        // given
        List<Integer> numbers = List.of(1, 2);

        // when then
        assertThatThrownBy(() -> new PlayerNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_ERROR_TITLE.getTitle() + WRONG_SIZE_ERROR.getMessage());
    }

    @DisplayName("숫자 중 0이 포함된 경우 예외 처리")
    @Test
    void validateNumbersHasZero() {
        // given
        List<Integer> numbers = List.of(0, 1, 2);

        // when then
        assertThatThrownBy(() -> new PlayerNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_ERROR_TITLE.getTitle() + HAS_ZERO_ERROR.getMessage());
    }

    @DisplayName("중복된 숫자가 존재하는 경우 예외 처리")
    @Test
    void validateNumbersDuplicated() {
        // given
        List<Integer> numbers = List.of(1, 1, 2);

        // when then
        assertThatThrownBy(() -> new PlayerNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_ERROR_TITLE.getTitle() + DUPLICATED_ERROR.getMessage());
    }

}