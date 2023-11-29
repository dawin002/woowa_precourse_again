package week1_baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;
    public static int createNumber() {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
