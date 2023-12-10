package week2_racing_car.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int createNumberInRange(int startRange, int endRange) {
        return Randoms.pickNumberInRange(startRange, endRange);
    }
}
