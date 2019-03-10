package tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberGeneratorTest {

    // 회차 생성 테스트
    @Test
    public void 이닝생성() {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        BaseballNumbers baseballNumbers = baseballNumberGenerator.generateBaseballNumbers();
        assertThat(baseballNumbers).isNotNull();
    }

}