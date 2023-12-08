package week1_baseball.message;

public enum ErrorMessage {
    ERROR_HEADER("[ERROR] "),
    INPUT_ERROR_TITLE("입력된 값"),
    COMPUTER_ERROR_TITLE("정답 숫자"),
    PLAYER_ERROR_TITLE("입력된 숫자"),
    RESULT_ERROR_TITLE("계산 결과"),
    RESTART_ERROR_TITLE("게임 재시작 숫자"),
    EMPTY_INPUT_ERROR_MESSAGE("이 비어 있습니다."),
    CAN_NOT_PARSE_INT_ERROR_MESSAGE("에 숫자가 아닌 값이 있습니다."),
    WRONG_SIZE_ERROR("가 3자리 숫자가 아닙니다."),
    HAS_ZERO_ERROR("에 1~9 사이가 아닌 숫자가 포함되었습니다."),
    DUPLICATED_ERROR("에 중복된 숫자가 존재합니다."),
    NO_MATCH_RESULT_ERROR("에 일치하는 조건의 결과가 없습니다."),
    WRONG_RESTART_NUMBER_ERROR("가 1 또는 2가 아닙니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return ERROR_HEADER.message + this.message;
    }

    public String getMessage() {
        return this.message;
    }
}