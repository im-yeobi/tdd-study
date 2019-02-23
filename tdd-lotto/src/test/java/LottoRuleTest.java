import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRuleTest {
    @Test
    public void getUserNumber() {
        LottoRule lottoRule = new LottoRule();
        assertThat(lottoRule.userNumber).isEqualTo(6);
    }

    @Test
    public void getLottoNumber() {
        LottoRule lottoRule = new LottoRule();
        assertThat(lottoRule.lottoNumber).isEqualTo(7);
    }

    @Test
    public void getLottoMaxNumber() {
        LottoRule lottoRule = new LottoRule();
        assertThat(lottoRule.lottoMaxNumber).isEqualTo(45);
    }
}