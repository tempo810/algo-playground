package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class IntegerToRomanTest {
    private final IntegerToRoman solution = new IntegerToRoman();

    @Test
    void test() {
        assertThat(solution.intToRoman(4)).isEqualTo("IV");
        assertThat(solution.intToRoman(58)).isEqualTo("LVIII");
    }
}
