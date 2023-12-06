package week1_baseball.model;

import java.util.Collections;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if ()
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
