package week1_baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week1_baseball.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    @DisplayName("1~9 범위의 랜덤 숫자 생성")
    @Test
    void createRandomNumberInRangeFrom1To9() {
        // given
        List<Integer> numbers = new ArrayList<>();

        // when
        for (int i = 0; i < 100; i++) {
            numbers.add(NumberGenerator.createNumber());
        }

        // then
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(NUMBER_RANGE_START);
            assertThat(number).isLessThanOrEqualTo(NUMBER_RANGE_END);
        }
    }
}