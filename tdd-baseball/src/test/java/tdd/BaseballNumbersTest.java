package tdd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumbersTest {

    List<BaseballNumber> baseballNumber;

    @Test
    public void setUp() {
        baseballNumber = new ArrayList<>();
        baseballNumber.add(new BaseballNumber(1));
        baseballNumber.add(new BaseballNumber(2));
        baseballNumber.add(new BaseballNumber(3));
    }

    @Test
    public void 번호3개_생성() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(baseballNumber);
        assertThat(baseballNumbers.getBaseballNumberList().size()).isEqualTo(3);
    }

}