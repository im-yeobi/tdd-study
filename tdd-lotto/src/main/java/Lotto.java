import java.util.Random;

public class Lotto {

    int[][] userLottoNum;
    int[] lottoNum;

    public int[] lottoProgram(int N) {
        createRandomUserLottoNum(N);
        createRandomLottoNum();

        //  등수통계, 1~7등
        int[] resultStatistics = new int[7];

        return resultStatistics;
    }

    private void createRandomUserLottoNum(int N) {
        userLottoNum = new int[N][7];
        Random generator = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < userLottoNum[i].length; j++) {
                userLottoNum[i][j] = generator.nextInt(45) + 1;
            }
        }
    }

    private void createRandomLottoNum() {
        lottoNum = new int[7];
        Random generator = new Random();
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = generator.nextInt(45) + 1;
        }
    }

}
