package week1_baseball.message;

public enum ErrorMessages {
    ERROR_HEADER("[ERROR] "),
    COMPUTER_TITLE("정답 숫자"),
    PLAYER_TITLE("입력된 숫자"),
    WRONG_SIZE_ERROR("가 3자리 숫자가 아닙니다."),
    HAS_ZERO_ERROR("에 1~9 사이가 아닌 숫자가 포함되었습니다."),
    DUPLICATED_ERROR("에 중복된 숫자가 존재합니다."),
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getComputerMessage() {
        return String.format(ERROR_HEADER.message, COMPUTER_TITLE.message, this.message);
    }

    public String getPlayerMessage() {
        return String.format(ERROR_HEADER.message, PLAYER_TITLE.message, this.message);
    }
}