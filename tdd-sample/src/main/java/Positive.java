public class Positive {
    // 클래스 분리 연습을 위해 활용할 수 있는 원칙
    // 일급 콜렉션을 쓴다
    // 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

    private int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Positive add(Positive other) {
        return new Positive(this.number + other.number);
    }

    public int getNumber() {
        return number;
    }
}
