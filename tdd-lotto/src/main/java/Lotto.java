
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private List<int[]> userLottoNum;
    private int[] lottoNum;
    //  등수통계, 1~7등
    private int[] resultStatistics = new int[5];
    private long N;
    private LottoRule lottoRule;

    Lotto() {}
    Lotto(long N) {
        this.N = N;
        this.lottoRule = new LottoRule();
    }

    public int[] lottoProgram() {
        createRandomUserLottoNum();
        createRandomLottoNum();
        System.out.print("lottoNum : ");
        for (int i = 0; i < lottoRule.lottoNumber; i++) {
            System.out.print(lottoNum[i] + " ");
        }
        System.out.println();
        operateLottoNum();
        printLottoResult();

        return resultStatistics;
    }

    // 사용자 번호 생성
    private void createRandomUserLottoNum() {
        userLottoNum = new ArrayList<>();
        for (long i = 0L; i < N; i++) {
            userLottoNum.add(createRandomNum(lottoRule.userNumber));
        }
    }

    // 로또 번호 생성
    private void createRandomLottoNum() {
        lottoNum = createRandomNum(lottoRule.lottoNumber);
    }

    // 사용자 번호, 로또 번호 공통 생성기
    private int[] createRandomNum(int length) {
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            createEachNum(temp, i);
        }
        return temp;
    }

    // 1~45 숫자 중 랜덤하게 하나씩 생성
    private void createEachNum(int[] arr, int idx) {
        Random random = new Random();
        do {
            arr[idx] = random.nextInt(lottoRule.lottoMaxNumber) + 1;
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

    private void operateLottoNum() {
        for (int[] user : userLottoNum) {
            compareUserLottoNum(user);
        }
    }

    private void compareUserLottoNum(int[] user) {
        int normalCnt = 0;
        int bonusCnt = 0;
        for (int i = 0; i < lottoRule.userNumber; i++) {
            normalCnt += compareEachLottoNum(user[i], 0);
            bonusCnt += compareBonusNum(user[i]);
        }

        if (normalCnt == 6) {
            for (int i = 0; i < lottoRule.userNumber; i++) {
                System.out.print(user[i] + " ");
            }
            System.out.println();
        }

        if (normalCnt > 2) {
            judgeRank(normalCnt, bonusCnt);
        }
    }

    private int compareEachLottoNum(int userNum, int idx) {
        if (userNum == lottoNum[idx]) {
            return 1;
        }

        if (idx == lottoRule.lottoNumber-2) {
            return 0;
        }

        return compareEachLottoNum(userNum, ++idx);
    }

    private int compareBonusNum(int userNum) {
        if (userNum == lottoNum[lottoRule.lottoNumber-1]) {
            return 1;
        }

        return 0;
    }

    private void judgeRank(int normalCnt, int bonusCnt) {
        if ( normalCnt == 6 ) {
            // 1등
            resultStatistics[0]++;
        } else if ( normalCnt == 5 && bonusCnt == 1 ) {
            // 2등
            resultStatistics[1]++;
        } else if ( normalCnt == 5 ) {
            // 3등
            resultStatistics[2]++;
        } else if ( normalCnt == 4 ) {
            // 4등
            resultStatistics[3]++;
        } else if ( normalCnt == 3 ) {
            // 5등
            resultStatistics[4]++;
        }
    }

    private void printLottoResult() {
        for (int i = 0; i < resultStatistics.length; i++) {
            System.out.println((i+1) + "등 : " + resultStatistics[i] + " 명");
        }
    }

}
