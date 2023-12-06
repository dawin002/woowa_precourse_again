package week1_baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static week1_baseball.model.NumberInfo.*;

class ComputerNumbersTest {
    private ComputerNumbers computerNumbers;

    @BeforeEach
    void setUp() {
        this.computerNumbers = new ComputerNumbers();
    }

    @DisplayName("3개의 숫자를 가진 정답 객체 생성")
    @Test
    void computerNumbersHas3Numbers() {
        // given when : setUp()

        // then
        List<Integer> numbers = computerNumbers.getNumbers();
        assertThat(numbers.size()).isEqualTo(NUMBERS_SIZE.getNumber());
    }

    @DisplayName("1~9 범위의 숫자를 가진 정답 객체 생성")
    @Test
    void computerNumbersInNumberRangeForm1To9() {
        // given when : setUp()

        // then
        List<Integer> numbers = computerNumbers.getNumbers();
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(NUMBER_RANGE_START.getNumber());
            assertThat(number).isLessThanOrEqualTo(NUMBER_RANGE_END.getNumber());
        }
    }

}