package week1_baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static week1_baseball.message.ErrorMessage.*;
import static week1_baseball.model.NumberInfo.NUMBERS_SIZE;
import static week1_baseball.model.NumberInfo.NUMBER_ZERO;

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
            throw new IllegalArgumentException(WRONG_SIZE_ERROR.getPlayerMessage());
        }
    }

    private void checkHasZero(List<Integer> numbers) {
        if (numbers.contains(NUMBER_ZERO.getNumber())) {
            throw new IllegalArgumentException(HAS_ZERO_ERROR.getPlayerMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getPlayerMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
