import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void lottoProgram() {
        Lotto lotto = new Lotto();
        assertThat(lotto.lottoProgram(10).length).isEqualTo(7);
    }

//    @Test
//    public void createRandomUserLottoNum() {
//        // 사용자 로또 번호 생성
//        Lotto lotto = new Lotto();
//        assertThat(lotto.createRandomUserLottoNum(10).length).isEqualTo(10);
//    }
//
//    @Test
//    public void createRandomLottoNum() {
//        // 로또 번호 생성
//        Lotto lotto = new Lotto();
//        assertThat(lotto.createRandomLottoNum().length).isEqualTo(7);
//    }



}
