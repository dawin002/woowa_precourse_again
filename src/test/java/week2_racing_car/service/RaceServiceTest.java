package week2_racing_car.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
//        assertThat()
    }

}