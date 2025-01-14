package week1_baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerNumbersTest {
    @DisplayName("전달된 숫자 리스트로 초기화된 정답 숫자 객체 생성")
    @Test
    void computerNumbersInitializedByGivenNumbers() {
        // given
        List<Integer> givenNumbers = List.of(1, 2, 3);

        // when
        ComputerNumbers computerNumbers = new ComputerNumbers(givenNumbers);

        // then
        for (int number : givenNumbers) {
            assertThat(computerNumbers.getNumbers()).contains(number);
        }
    }

    @DisplayName("정답 숫자가 3자리가 아니라면 예외 처리")
    @Test
    void validateComputerNumbersSize() {
        // given
        List<Integer> givenNumbers = List.of(1, 2);

        // when then
        assertThatThrownBy(() -> new ComputerNumbers(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정답 숫자가 3자리 숫자가 아닙니다.");
    }

    @DisplayName("정답 숫자에 0이 포함된 경우 예외 처리")
    @Test
    void validateComputerNumbersNotContainsZero() {
        // given
        List<Integer> givenNumbers = List.of(0, 1, 2);

        // when then
        assertThatThrownBy(() -> new ComputerNumbers(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정답 숫자에 1~9 사이가 아닌 숫자가 포함되었습니다.");
    }

    @DisplayName("정답 숫자에 중복이 존재하는 경우 예외 처리")
    @Test
    void validateComputerNumbersDuplicated() {
        // given
        List<Integer> givenNumbers = List.of(1, 1, 2);

        // when then
        assertThatThrownBy(() -> new ComputerNumbers(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정답 숫자에 중복된 숫자가 존재합니다.");
    }

}