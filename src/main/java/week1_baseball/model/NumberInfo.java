package week1_baseball.model;

public enum NumberInfo {
    NUMBERS_SIZE(3),
    NUMBER_RANGE_START(1),
    NUMBER_RANGE_END(9),
    NUMBER_ZERO(0);

    private final int number;

    NumberInfo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
