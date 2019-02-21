
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    List<int[]> userLottoNum;
    int[] lottoNum;
    //  등수통계, 1~7등
    int[] resultStatistics = new int[5];

    int userCnt = 6;
    int lottoCnt = 7;
    int lottoMaxNum = 45;

    public int[] lottoProgram(long N) {
        createRandomUserLottoNum(N);
        createRandomLottoNum();
        operateLottoNum();
        printLottoResult();

        return resultStatistics;
    }

    // 사용자 번호 생성
    private void createRandomUserLottoNum(long N) {
        userLottoNum = new ArrayList<>();
        Random generator = new Random();
        for (long i = 0L; i < N; i++) {
            int[] temp = new int[userCnt];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = generator.nextInt(lottoMaxNum) + 1;
                while (checkValidity(temp, j)) {
                    temp[j] = generator.nextInt(lottoMaxNum) + 1;
                }
            }
            userLottoNum.add(temp);
        }
    }

    // 로또 번호 생성
    private void createRandomLottoNum() {
        lottoNum = new int[lottoCnt];
        Random generator = new Random();
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = generator.nextInt(lottoMaxNum) + 1;
            while (checkValidity(lottoNum, i)) {
                lottoNum[i] = generator.nextInt(lottoMaxNum) + 1;
            }
        }
    }

    // 로또 번호 중복 체크
    private boolean checkValidity(int[] arr, int idx) {
        for (int i = 0; i < idx; i++) {
            if (arr[idx] == arr[i]) {
                return true;
            }
        }
        return false;
    }

    private void operateLottoNum() {
        for (int[] user : userLottoNum) {
            int normalCnt = 0;
            int bonusCnt = 0;
            for (int i = 0; i < userCnt; i++) {
                for (int j = 0; j < lottoCnt; j++) {
                    if (user[i] == lottoNum[j]) {
                        if ( j == (lottoCnt - 1) ) {
                            bonusCnt++;
                        } else {
                            normalCnt++;
                        }
                    }
                }

            }
            if (normalCnt >= 2) {
                judgeRank(normalCnt, bonusCnt);
            }
        }
    }

    private void judgeRank(int normalCnt, int bonusCnt) {
        if ( normalCnt == 6 ) {
            // 1등
            resultStatistics[0]++;
        } else if ( normalCnt == 5 && bonusCnt == 1 ) {
            // 2등
            resultStatistics[1]++;
        } else if ( normalCnt == 4 ) {
            // 3등
            resultStatistics[2]++;
        } else if ( normalCnt == 3 ) {
            // 4등
            resultStatistics[3]++;
        } else if ( normalCnt == 2 ) {
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
