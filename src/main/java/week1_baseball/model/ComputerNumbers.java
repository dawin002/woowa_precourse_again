package week1_baseball.model;

import week1_baseball.service.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumbers {
    private static final int NUMBERS_SIZE = 3;
    private final List<Integer> numbers;

    public ComputerNumbers() {
        this.numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_SIZE) {
            int randomNumber = NumberGenerator.createNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
