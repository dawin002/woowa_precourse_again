package week1_baseball.utils;

import java.util.ArrayList;
import java.util.List;

import static week1_baseball.message.ErrorMessage.*;

public class InputParser {

    private static final String SPLIT_REGEX = "";
    private static final int ASCII_OF_CHAR_ZERO = 48;
    private static final int ASCII_OF_CHAR_NINE = 57;

    public static List<Integer> stringToIntList(String input) {
        validateInputNumbers(input);
        String[] splitInput = input.split(SPLIT_REGEX);
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static int stringToInt(String input) {
        validateInputNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateInputNumbers(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ERROR_TITLE.getTitle() +
                    EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (canNotParseInteger(input)) {
            throw new IllegalArgumentException(INPUT_ERROR_TITLE.getTitle() +
                    CAN_NOT_PARSE_INT_ERROR_MESSAGE.getMessage());
        }
    }

    private static void validateInputNumber(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_ERROR_TITLE.getTitle() +
                    EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
        if (canNotParseInteger(input)) {
            throw new IllegalArgumentException(INPUT_ERROR_TITLE.getTitle() +
                    CAN_NOT_PARSE_INT_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean canNotParseInteger(String input) {
        for (char number : input.toCharArray()) {
            if (ASCII_OF_CHAR_ZERO > (int) number || ASCII_OF_CHAR_NINE < (int) number) {
                return true;
            }
        }
        return false;
    }
}
