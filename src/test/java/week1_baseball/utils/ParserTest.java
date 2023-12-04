package week1_baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    @DisplayName("전달된 문자열을 정수 리스트로 변환해 반환")
    @ValueSource(strings = {"123", "246", "999"})
    @ParameterizedTest
    void parseStringToIntList(String input) {
        // given when
        List<Integer> numbers = Parser.stringToIntList(input);

        // then
        String[] splitInput = input.split("");
        for (int i = 0; i < numbers.size(); i++) {
            assertThat(numbers.get(i)).isEqualTo(Integer.parseInt(splitInput[i]));
        }
    }

    @DisplayName("문자열이 비어있는 경우 예외 처리")
    @ValueSource(strings = {"", " ", "   "})
    @ParameterizedTest
    void validateInputEmpty(String input) {
        // given when then
        assertThatThrownBy(() -> Parser.stringToIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값이 비어 있습니다.");
    }

    @DisplayName("문자열을 정수로 변환할 수 없는 경우 예외 처리")
    @ValueSource(strings = {"-123", "0.512", "12!", "13a"})
    @ParameterizedTest
    void validateInputCanNotParseInteger(String input) {
        // given when then
        assertThatThrownBy(() -> Parser.stringToIntList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값에 숫자가 아닌 값이 있습니다.");
    }

}