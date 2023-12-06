package week1_baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
            throw new IllegalArgumentException("정답 숫자가 3자리가 아닙니다.");
        }
        if (numbers.contains(NUMBER_ZERO.getNumber())) {
            throw new IllegalArgumentException("1~9 사이가 아닌 숫자가 포함되었습니다.");
        }
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
