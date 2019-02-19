import java.util.Random;

public class Lotto {

    public int[][] createRandomUserLottoNum(int N) {
        int[][] userLottoNum = new int[N][7];
        Random generator = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < userLottoNum[i].length; j++) {
                userLottoNum[i][j] = generator.nextInt(45) + 1;
            }
        }

        return userLottoNum;
    }

    public int[] createRandomLottoNum() {
        int[] lottoNum = new int[7];
        Random generator = new Random();
        for (int i = 0; i < lottoNum.length; i++) {
            lottoNum[i] = generator.nextInt(45) + 1;
        }

        return lottoNum;
    }

}
