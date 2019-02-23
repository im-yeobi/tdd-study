import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoUserTest {
    // 로또 사용자 생성
    @Test
    public void lottoUser() {
        LottoUser lottoUser = new LottoUser();
        assertThat(lottoUser.userLottoNum.length).isEqualTo(6);
    }

    // 로또 사용자 N명 생성
    @Test
    public void lottoUsers() {
        List<LottoUser> lottoUsers = new ArrayList<LottoUser>();
        lottoUsers.add(new LottoUser());
        assertThat(lottoUsers.size()).isEqualTo(1);
        assertThat(lottoUsers.get(0).getClass()).isEqualTo(LottoUser.class);
    }
}