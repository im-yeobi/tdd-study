import java.util.ArrayList;
import java.util.Random;

public class LottoGenerator {
    // 사용자 번호, 로또 번호 공통 생성기
    public int[] generateLottoNum(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            createEachNum(arr, i);
        }
        return arr;
    }

    // 1~45 숫자 중 랜덤하게 하나씩 생성
    private void createEachNum(int[] arr, int idx) {
        Random random = new Random();
        do {
            arr[idx] = random.nextInt(LottoRule.lottoMaxNumber) + 1;
            // 기존 값과 중복여부 체크
        } while (checkPreNum (arr[idx], arr, idx));
    }

    // 로또 번호 중복 체크
    private boolean checkPreNum(int value, int[] arr, int idx) {
        if (idx == 0) {
            return false;
        }

        if (value == arr[idx-1]) {
            return true;
        }

        return checkPreNum(value, arr, --idx);
    }
}
