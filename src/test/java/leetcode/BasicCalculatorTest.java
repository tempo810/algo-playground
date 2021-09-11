package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class BasicCalculatorTest {
    private final BasicCalculator solution = new BasicCalculator();

    @Test
    void parse() {
        assertThat(solution.calculate("(1+(4+5+2)-3)+(6+8)")).isEqualTo(23);
        assertThat(solution.calculate("10 + 2 + 3")).isEqualTo(15);
        assertThat(solution.calculate("10+2+3")).isEqualTo(15);
        assertThat(solution.calculate("2-10+3")).isEqualTo(-5);
    }
}
