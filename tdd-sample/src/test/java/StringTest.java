import org.junit.Test;

        import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");

        values = "1,2".split(",");
        assertThat(values).contains("1", "2");
    }

    @Test
    public void substring() {
        String input = "(1,2)";
        String result = input.substring(1, 2);
//        assertThat(input.length()).isEqualTo(4);
        assertThat(result).isEqualTo("1,2");
    }
}
