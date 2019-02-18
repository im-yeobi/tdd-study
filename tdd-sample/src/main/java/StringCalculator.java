public class StringCalculator {
    // 리팩토링
    // 명확하고 구체적인 목표를 가지고 진행
    // 피드백과 피드백에 따른 행동 변경을 수반

    /*
    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            result = 0;
        } else {
            String[] values = text.split(",|:");
            for (String value : values) {
                result += Integer.parseInt(value);
            }
        }

        return result;
    }
    */

    /*
    // 한 메서드에 오직 한 단계의 들여쓰기(intent)만 한다.
    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isEmpty()) {
            result = 0;
        } else {
            String[] values = text.split(",|:");
            result = sum(values);
        }

        return result;
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
    */

    /*
    // else 예약어를 쓰지 않는다.
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",|:");
        return sum(values);
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
    */

    /*
    // 메소드가 한 가지 일만 하도록 구현하기
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",|:");
        int[] numbers = toInts(values);
        return sum(numbers);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
    */

    // 로컬 변수가 정말 필요한가?
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sum(toInts(text.split(",|:")));
    }

    private static Positive[] toInts(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = new Positive(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.add(number);
        }
        return result.getNumber();
    }
}
