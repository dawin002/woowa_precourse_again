package week1_baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week1_baseball.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    private static final int NUMBERS_SIZE = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    @DisplayName("1~9 범위의 중복되지 않은 3개의 숫자 생성")
    @Test
    void createRandomNumbers() {
        // given

        // when
        List<Integer> numbers = NumberGenerator.createUniqueNumbers();

        // then
        assertThat(numbers.size()).isEqualTo(NUMBERS_SIZE);
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(NUMBER_RANGE_START);
            assertThat(number).isLessThanOrEqualTo(NUMBER_RANGE_END);
        }
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        assertThat(numberSet.size()).isEqualTo(NUMBERS_SIZE);
    }
}