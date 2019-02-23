import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSupplierTest {
    // 로또 공급자 생성
    @Test
    public void lottoSupplier() {
        LottoSupplier lottoSupplier = new LottoSupplier();
        assertThat(lottoSupplier.lottoNum.length).isEqualTo(7);
    }
}
