package week1_baseball.message;

public enum ResultMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    SPACE(" ");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
