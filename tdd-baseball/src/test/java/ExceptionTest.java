import org.junit.Before;
import org.junit.Test;
import tdd.BaseballNumber;
import tdd.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    // 예외 케이스 테스트

    List<BaseballNumber> baseballNumber = new ArrayList<>();

    @Before
    public void setUp() {
        baseballNumber.add(new BaseballNumber(1));
        baseballNumber.add(new BaseballNumber(2));
        baseballNumber.add(new BaseballNumber(3));
    }

    // 1. 숫자 유효범위(0~9) 어긋나는 경우
    @Test(expected = IllegalArgumentException.class)
    public void 유효범위0미만() {
        BaseballNumber baseBallNumber = new BaseballNumber(BaseballNumber.BASEBALL_MIN - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효범위9초과() {
        BaseballNumber baseBallNumber = new BaseballNumber(BaseballNumber.BASEBALL_MAX + 1);
    }

    // 2. 개수범위 3개 아닌 경우
    @Test(expected = IllegalArgumentException.class)
    public void 개수범위1미만() {
        baseballNumber.clear();  // 하나도 없는 경우
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개수범위1개() {
        baseballNumber.remove(0);
        baseballNumber.remove(0);
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개수범위2개() {
        baseballNumber.remove(0);
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 개수범위3초과() {
        baseballNumber.add(new BaseballNumber(4));
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumber);
    }

    // 3. 입력 값이 null인 경우
//    @Test(expected = IllegalArgumentException.class)
//    public void
}
