package week1_baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static week1_baseball.message.ErrorMessage.*;
import static week1_baseball.model.BaseballNumbersInfo.NUMBERS_SIZE;
import static week1_baseball.model.BaseballNumbersInfo.NUMBER_ZERO;

public class PlayerNumbers {
    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkHasZero(numbers);
        checkDuplicate(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE.getNumber()) {
            throw new IllegalArgumentException(PLAYER_ERROR_TITLE.getTitle() +
                    WRONG_SIZE_ERROR.getMessage());
        }
    }

    private void checkHasZero(List<Integer> numbers) {
        if (numbers.contains(NUMBER_ZERO.getNumber())) {
            throw new IllegalArgumentException(PLAYER_ERROR_TITLE.getTitle() +
                    HAS_ZERO_ERROR.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(PLAYER_ERROR_TITLE.getTitle() +
                    DUPLICATED_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
