package tdd;

import java.util.List;

public class BaseballNumbers {

    public static final int BASEBALL_SIZE = 3;
    private List<BaseballNumber> baseballNumberList;

    public BaseballNumbers(List<BaseballNumber> baseballNumberList) {
        if (baseballNumberList.size() < BASEBALL_SIZE || baseballNumberList.size() > BASEBALL_SIZE) {
            throw new IllegalArgumentException("3자리 숫자만 가능");
        }

        if (duplicateCheck(baseballNumberList)) {
            throw new IllegalArgumentException("중복값 존재");
        }

        this.baseballNumberList = baseballNumberList;
    }

    private boolean duplicateCheck(List<BaseballNumber> baseballNumbers) {
        long count = baseballNumbers.parallelStream()
                .map(BaseballNumber::getNumber) // getter를 굳이 만들어서 중복 체크를 함. equals hashCode 이용하여 해보기
                .distinct().count();
        // 중복값 존재하면 true
        // 중복값 존재하지 않으면 false
        return count != BASEBALL_SIZE;
    }

    public List<BaseballNumber> getBaseballNumberList() {
        return baseballNumberList;
    }
}
