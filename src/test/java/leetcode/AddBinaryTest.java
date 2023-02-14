package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class AddBinaryTest {
    private AddBinary solution = new AddBinary();

    @Test
    void addBinary() {
        Assertions.assertThat(solution.addBinary("11", "1")).isEqualTo("100");
    }
}
