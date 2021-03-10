package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class IntegerToRomanTest {
    private final IntegerToRoman solution = new IntegerToRoman();

    @Test
    void test() {
        assertThat(solution.intToRoman(4), Matchers.is("IV"));
        assertThat(solution.intToRoman(58), Matchers.is("LVIII"));
    }
}
