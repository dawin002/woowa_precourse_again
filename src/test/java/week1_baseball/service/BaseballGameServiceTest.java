package week1_baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import week1_baseball.dto.BaseballGameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameServiceTest {

    private BaseballGameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new BaseballGameService();
        gameService.setComputerNumbers(List.of(1, 2, 3));
    }

    @DisplayName("볼 개수를 계산해 반환")
    @CsvSource(value = {"4,5,6,0", "4,5,1,1", "4,3,1,2", "3,1,2,3"})
    @ParameterizedTest
    void calculateBallCount(int number1, int number2, int number3, int ballCount) {
        // given
        gameService.setPlayerNumbers(List.of(number1, number2, number3));

        // when
        BaseballGameResult result = gameService.calculateResult();

        // then
        assertThat(result.getBall()).isEqualTo(ballCount);
    }

    @DisplayName("스트라이크 개수를 계산해 반환")
    @CsvSource(value = {"4,5,6,0", "1,5,6,1", "1,2,6,2", "1,2,3,3"})
    @ParameterizedTest
    void calculateStrikeCount(int number1, int number2, int number3, int ballCount) {
        // given
        gameService.setPlayerNumbers(List.of(number1, number2, number3));

        // when
        BaseballGameResult result = gameService.calculateResult();

        // then
        assertThat(result.getStrike()).isEqualTo(ballCount);
    }

    @DisplayName("정답 여부를 계산해 반환")
    @CsvSource(value = {"4,5,6,false", "3,1,2,false", "1,2,4,false", "1,3,2,false", "1,2,3,true"})
    @ParameterizedTest
    void calculateIsAnswer(int number1, int number2, int number3, boolean isAnswer) {
        // given
        gameService.setPlayerNumbers(List.of(number1, number2, number3));

        // when
        BaseballGameResult result = gameService.calculateResult();

        // then
        assertThat(result.isFullStrike()).isEqualTo(isAnswer);
    }
}