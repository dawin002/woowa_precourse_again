package week1_baseball.message;

public enum ResultMessages {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    SPACE(" ");

    private final String message;

    ResultMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
