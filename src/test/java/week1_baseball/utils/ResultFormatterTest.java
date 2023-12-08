package week1_baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import week1_baseball.dto.BaseballGameResult;

import static org.assertj.core.api.Assertions.assertThat;
import static week1_baseball.message.ResultMessage.*;

class ResultFormatterTest {

    @DisplayName("볼 스트라이크가 없는 경우의 결과 문구 반환")
    @CsvSource(value = {"0,0,false"})
    @ParameterizedTest
    void formatResultWhenNothing(int strike, int ball, boolean isAnswer) {
        // given
        BaseballGameResult gameResult = new BaseballGameResult(strike, ball, isAnswer);

        // when
        String outputResult = ResultFormatter.createResultMessage(gameResult);

        // then
        assertThat(outputResult).isEqualTo(NOTHING.getMessage());
        assertThat(outputResult).doesNotContain(STRIKE.getMessage(), BALL.getMessage());
    }

    @DisplayName("스트라이크만 있는 경우의 결과 문구 반환")
    @CsvSource(value = {"1,0,false", "2,0,false", "3,0,true"})
    @ParameterizedTest
    void formatResultWhenOnlyStrike(int strike, int ball, boolean isAnswer) {
        // given
        BaseballGameResult gameResult = new BaseballGameResult(strike, ball, isAnswer);

        // when
        String outputResult = ResultFormatter.createResultMessage(gameResult);

        // then
        assertThat(outputResult).contains(strike + STRIKE.getMessage());
        assertThat(outputResult).doesNotContain(BALL.getMessage(), NOTHING.getMessage());
    }

    @DisplayName("볼만 있는 경우의 결과 문구 반환")
    @CsvSource(value = {"0,1,false", "0,2,false", "0,3,false"})
    @ParameterizedTest
    void formatResultWhenOnlyBall(int strike, int ball, boolean isAnswer) {
        // given
        BaseballGameResult gameResult = new BaseballGameResult(strike, ball, isAnswer);

        // when
        String outputResult = ResultFormatter.createResultMessage(gameResult);

        // then
        assertThat(outputResult).contains(ball + BALL.getMessage());
        assertThat(outputResult).doesNotContain(STRIKE.getMessage(), NOTHING.getMessage());
    }

    @DisplayName("스트라이크와 볼이 모두 있는 경우의 결과 문구 반환")
    @CsvSource(value = {"1,1,false", "1,2,false", "2,1,false"})
    @ParameterizedTest
    void formatResultWhenStrikeAndBall(int strike, int ball, boolean isAnswer) {
        // given
        BaseballGameResult gameResult = new BaseballGameResult(strike, ball, isAnswer);

        // when
        String outputResult = ResultFormatter.createResultMessage(gameResult);

        // then
        assertThat(outputResult).contains(ball + BALL.getMessage() + SPACE.getMessage() + strike + STRIKE.getMessage());
        assertThat(outputResult).doesNotContain(NOTHING.getMessage());
    }

}