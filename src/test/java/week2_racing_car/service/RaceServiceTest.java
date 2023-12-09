package week2_racing_car.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week2_racing_car.dto.CarResult;
import week2_racing_car.dto.SingleRaceResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceServiceTest {
    private RaceService raceService;

    @BeforeEach
    void setUp() {
        this.raceService = new RaceService();
    }

    @DisplayName("전달된 이름으로 초기화한 자동차 리스트 생성")
    @Test
    void createCarsWithGivenNames() {
        // given
        List<String> carNames = List.of("a", "bc", "def", "dawin");

        // when
        raceService.setCars(carNames);

        // then
        SingleRaceResult raceResult = raceService.getResult();
        List<CarResult> carResults = raceResult.getResults();

        for (int i = 0; i < carResults.size(); i++) {
            assertThat(carResults.get(i).getName()).isEqualTo(carNames.get(i));
        }
    }

    @DisplayName("이동 거리를 0으로 초기화한 자동차 리스트 생성")
    @Test
    void createCarsWithDefaultDistance() {
        // given
        List<String> carNames = List.of("a", "b", "c", "d");

        // when
        raceService.setCars(carNames);

        // then
        SingleRaceResult raceResult = raceService.getResult();

        for (CarResult carResult : raceResult.getResults()) {
            assertThat(carResult.getDistance()).isEqualTo(0);
        }
    }

    @DisplayName("중복된 자동차 이름이 존재하는 경우 예외 처리")
    @Test
    void validateCarNamesNotDuplicated() {
        // given
        List<String> carNames = List.of("a", "b", "c", "a");

        // when then
        assertThatThrownBy(() -> raceService.setCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름은 입력할 수 없습니다.");
    }

}