package week1_baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PlayerNumbers {
    private final static Integer NUMBERS_SIZE = 3;
    private final static Integer NUMBER_ZERO = 0;
    private final static String ERROR_MESSAGE_WRONG_SIZE = "3자리 숫자가 아닙니다.";
    private final static String ERROR_MESSAGE_HAS_ZERO = "1~9 사이가 아닌 숫자가 포함되었습니다.";
    private final static String ERROR_MESSAGE_DUPLICATED_NUMBERS = "중복된 숫자가 있습니다.";
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
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_SIZE);
        }
    }

    private void checkHasZero(List<Integer> numbers) {
        if (numbers.contains(NUMBER_ZERO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HAS_ZERO);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
