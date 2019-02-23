import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    @Test
    public void lottoController() {
        LottoController lottoController = new LottoController(1000000);
        lottoController.calcLottoNum();
        lottoController.printLottoStatistics();

        assertThat(lottoController.lottoUsers.size()).isEqualTo(100000);
        assertThat(lottoController.lottoSupplier.lottoNum.length).isEqualTo(7);
        assertThat(lottoController.lottoStatistics).isEqualTo(5);
    }
}
