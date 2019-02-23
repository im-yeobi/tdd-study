import java.util.ArrayList;
import java.util.List;

public class LottoController {
    LottoSupplier lottoSupplier;
    List<LottoUser> lottoUsers;
    int[] lottoStatistics;

    LottoController() {}
    LottoController(int N) {
        lottoSupplier = new LottoSupplier();
        lottoUsers = new ArrayList<LottoUser>();
        lottoStatistics = new int[LottoRule.lottoLevel];
        for (int i = 0; i < N; i++) {
            lottoUsers.add(new LottoUser());
        }
    }

    public void calcLottoNum() {
        for (LottoUser lottoUser : lottoUsers) {
            compareUserLottoNum(lottoUser.userLottoNum);
        }
    }

    private void compareUserLottoNum(int[] lottoUser) {
        int normalCnt = 0;
        int bonusCnt = 0;
        for (int i = 0; i < LottoRule.userNumber; i++) {
            normalCnt += compareEachLottoNum(lottoUser[i], 0);
            bonusCnt += compareBonusNum(lottoUser[i]);
        }

        if (normalCnt > 2) {
            judgeRank(normalCnt, bonusCnt);
        }
    }

    private int compareEachLottoNum(int userNum, int idx) {
        if (userNum == lottoSupplier.lottoNum[idx]) {
            return 1;
        }

        if (idx == LottoRule.lottoNumber-2) {
            return 0;
        }

        return compareEachLottoNum(userNum, ++idx);
    }

    private int compareBonusNum(int userNum) {
        if (userNum == lottoSupplier.lottoNum[LottoRule.lottoNumber-1]) {
            return 1;
        }

        return 0;
    }

    private void judgeRank(int normalCnt, int bonusCnt) {
        switch(normalCnt) {
            case 6:
                // 1등
                lottoStatistics[0]++;
                break;
            case 5:
                // 2, 3등
                lottoStatistics[checkBonusCnt(bonusCnt)]++;
                break;
            case 4:
                // 4등
                lottoStatistics[3]++;
                break;
            case 3:
                // 5등
                lottoStatistics[4]++;
                break;
        }
    }

    private int checkBonusCnt(int bonusCnt) {
        if (bonusCnt == 1) {
            return 1;
        }
        return 2;
    }

    public void printLottoStatistics() {
        for (int i = 0; i < lottoStatistics.length; i++) {
            System.out.println((i+1) + "등 : " + lottoStatistics[i] + " 명");
        }
    }

}
