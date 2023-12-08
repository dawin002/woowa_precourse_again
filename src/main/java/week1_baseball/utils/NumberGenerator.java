package week1_baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static week1_baseball.model.BaseballNumbersInfo.*;

public class NumberGenerator {

    public static List<Integer> createUniqueNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBERS_SIZE.getNumber()) {
            int randomNumber = NumberGenerator.createNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
    private static int createNumber() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START.getNumber(), NUMBER_RANGE_END.getNumber());
    }
}
