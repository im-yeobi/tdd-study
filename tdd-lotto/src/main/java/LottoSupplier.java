public class LottoSupplier {
    public int[] lottoNum;
    LottoGenerator lottoGenerator;

    LottoSupplier() {
        lottoGenerator = new LottoGenerator();
        lottoNum = lottoGenerator.generateLottoNum(LottoRule.lottoNumber);
    }
}
