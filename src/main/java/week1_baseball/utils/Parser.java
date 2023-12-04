package week1_baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String ERROR_MESSAGE_INPUT_EMPTY = "입력된 값이 비어 있습니다.";
    private static final String ERROR_MESSAGE_CAN_NOT_PARSE_INTEGER = "입력된 값에 숫자가 아닌 값이 있습니다.";

    public static List<Integer> stringToIntList(String input) {
        validateInput(input);
        String[] splitInput = input.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static void validateInput(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_EMPTY);
        }
        if (canNotParseInteger(input))
            throw new IllegalArgumentException(ERROR_MESSAGE_CAN_NOT_PARSE_INTEGER);
        }

    private static boolean canNotParseInteger(String input) {
        for (char number : input.toCharArray()) {
            if ((int)'0' > (int)number || (int)'9' < (int)number) {
                return true;
            }
        }
        return false;
    }
}
