package week1_baseball.message;

public enum InputMessage {
    READ_PLAYER_NUMBERS_MESSAGE("숫자를 입력해주세요 : "),
    READ_REPLAY_NUMBER_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
