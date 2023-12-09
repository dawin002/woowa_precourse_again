package week2_racing_car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private final static int DEFAULT_DISTANCE = 0;

    @DisplayName("자동차 이름 및 거리 초기화")
    @CsvSource(value = {"a,0", "abc,1", "abcde,3"})
    @ParameterizedTest
    void initCarByNameAndDistance(String name, int distance) {
        // given
        // when
        Car car = new Car(name, distance);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 처리")
    @ValueSource(strings = {"", " ", "     "})
    @ParameterizedTest
    void validateNameNotEmptyOrBlank(String name) {
        // given
        // when then
        assertThatThrownBy(() -> new Car(name, DEFAULT_DISTANCE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("자동차 이름이 5글자 초과인 경우 예외 처리")
    @ValueSource(strings = {"abcdef", "dawinn", "dawin002"})
    @ParameterizedTest
    void validateNameLengthNotGreaterThenFive(String name) {
        // given
        // when then
        assertThatThrownBy(() -> new Car(name, DEFAULT_DISTANCE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 입력 가능합니다.");
    }

}