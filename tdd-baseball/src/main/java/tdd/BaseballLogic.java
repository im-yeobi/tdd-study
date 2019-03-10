package tdd;

import java.util.HashMap;
import java.util.Map;

public class BaseballLogic {

    BaseballLogic baseballLogic;

    private Map<String, Integer> result;
    private BaseballNumbers myNumbers;
    private BaseballNumbers adminNumbers;

    public BaseballLogic(BaseballNumbers myNumbers, BaseballNumbers adminNumbers) {
        this.myNumbers = myNumbers;
        this.adminNumbers = adminNumbers;
        result = new HashMap<>();
    }

    public Map<String, Integer> checkEachNumber() {
        int strikeCount = 0;
        int ballCount = 0;
        int outCount = 0;

        for (int i = 0; i < myNumbers.getBaseballNumberList().size(); i++) {
            for (int j = 0; j < adminNumbers.getBaseballNumberList().size(); j++) {
                if (myNumbers.getBaseballNumberList().get(i).getNumber() == adminNumbers.getBaseballNumberList().get(j).getNumber()) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            outCount = 1;
        }

        result.put("strike", strikeCount);
        result.put("ball", ballCount);
        result.put("out", outCount);

        return result;
    }

}
