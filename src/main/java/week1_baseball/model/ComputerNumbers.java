package week1_baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static week1_baseball.message.ErrorMessages.*;
import static week1_baseball.model.NumberInfo.NUMBERS_SIZE;
import static week1_baseball.model.NumberInfo.NUMBER_ZERO;

public class ComputerNumbers {
    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE.getNumber()) {
            throw new IllegalArgumentException(WRONG_SIZE_ERROR.getComputerMessage());
        }
        if (numbers.contains(NUMBER_ZERO.getNumber())) {
            throw new IllegalArgumentException(HAS_ZERO_ERROR.getComputerMessage());
        }
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getComputerMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
