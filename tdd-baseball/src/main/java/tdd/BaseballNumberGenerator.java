package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumberGenerator {
    private BaseballNumbers baseballNumbers;

    public BaseballNumbers generateBaseballNumbers() {
        BaseballNumbers baseballNumbers;
        baseballNumbers = new BaseballNumbers(generateBaseballNumber());

        return baseballNumbers;
    }

    private List<BaseballNumber> generateBaseballNumber() {
        List<BaseballNumber> baseballNumberList = new ArrayList<>();
        do {
            int number = createRandomNumber();
            if ( duplicateCheck(baseballNumberList, number) ) {
                continue;
            }
            baseballNumberList.add(new BaseballNumber(number));
        } while (baseballNumberList.size() < BaseballNumbers.BASEBALL_SIZE);

        return baseballNumberList;
    }

    private boolean duplicateCheck(List<BaseballNumber> baseballNumberList, int number) {
        for (BaseballNumber baseballNumber : baseballNumberList) {
            if (baseballNumber.getNumber() == number) {
                return true;
            }
        }

        return false;
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(BaseballNumber.BASEBALL_MAX) + 1;
    }

}
