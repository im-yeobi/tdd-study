package tdd;

import java.util.Map;

public class BaseballController {

    BaseballLogic baseballLogic;

    private int strikeCount = 0;
    private int ballCount = 0;
    private int outCount = 0;

    public boolean controlBaseballLogic(BaseballNumbers myNumbers, BaseballNumbers adminNumbers) {
        baseballLogic = new BaseballLogic(myNumbers, adminNumbers);
        Map<String, Integer> baseballResult = baseballLogic.checkEachNumber();

        this.strikeCount += baseballResult.get("strike");
        this.ballCount += baseballResult.get("ball");
        this.outCount += baseballResult.get("out");

        if (ballCount == 4) {
            outCount++;
            ballCount = 0;
            strikeCount = 0;
        }

        if (strikeCount == 3) {
            outCount++;
            ballCount = 0;
            strikeCount = 0;
        }

        if (outCount >= 3) {
            return false;
        }

        return true;
    }

}
