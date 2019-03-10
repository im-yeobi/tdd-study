package tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseballNumberTest {

    @Test
    public void 개별번호생성() {
        BaseballNumber baseballNumber = new BaseballNumber(1);
        assertThat(baseballNumber.getNumber()).isEqualTo(1);
    }

}