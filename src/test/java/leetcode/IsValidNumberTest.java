package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class IsValidNumberTest {
    private final IsValidNumber solution = new IsValidNumber();

    @Test
    void isNumber() {
        assertThat(solution.isNumber("005047e+6")).isTrue();
        assertThat(solution.isNumber(".e1")).isFalse();
        assertThat(solution.isNumber("46.e3")).isTrue();
        assertThat(solution.isNumber("+E3")).isFalse();
        assertThat(solution.isNumber("-1.")).isTrue();
        assertThat(solution.isNumber("0..")).isFalse();
        assertThat(solution.isNumber("3.")).isTrue();
        assertThat(solution.isNumber("0.1")).isTrue();
    }
}
