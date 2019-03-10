package tdd;

public class BaseballNumber {

    public static final int BASEBALL_MAX = 9;
    public static final int BASEBALL_MIN = 0;

    private int number;

    public BaseballNumber(int number) {
        if (number < BASEBALL_MIN || number > BASEBALL_MAX) {
            throw new IllegalArgumentException("유효하지 않은 숫자 범위.");
        }

        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

}
