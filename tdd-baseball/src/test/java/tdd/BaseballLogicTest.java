package tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballLogicTest {

    BaseballNumbers myBaseballNumbers;
    BaseballNumbers adminBaseballNumbers;
    BaseballLogic baseballLogic;

    @Before
    public void setUp() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        List<BaseballNumber> baseballNumberList = new ArrayList<>();
        baseballNumberList.add(new BaseballNumber(1));
        baseballNumberList.add(new BaseballNumber(2));
        baseballNumberList.add(new BaseballNumber(3));
        myBaseballNumbers = new BaseballNumbers(baseballNumberList);
        adminBaseballNumbers = new BaseballNumbers(baseballNumberList);
    }

    @Test
    public void 베이스볼로직() {
        baseballLogic = new BaseballLogic(myBaseballNumbers, adminBaseballNumbers);
        Map<String, Integer> result = baseballLogic.checkEachNumber();
        assertThat(result.get("strike")).isEqualTo(3);

    }

}