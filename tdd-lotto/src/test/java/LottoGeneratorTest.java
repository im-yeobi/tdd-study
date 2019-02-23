import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    // 로또 번호 생성 테스트
    @Test
    public void generateLottoNum() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generateLottoNum(LottoRule.lottoNumber).length).isEqualTo(7);
    }
}