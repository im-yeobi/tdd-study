public class LottoUser {
    public int[] userLottoNum;
    LottoGenerator lottoGenerator;

    LottoUser() {
        lottoGenerator = new LottoGenerator();
        userLottoNum = lottoGenerator.generateLottoNum(LottoRule.userNumber);
    }
}
