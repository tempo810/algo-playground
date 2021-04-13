package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class DecodeWaysTest {
    private final DecodeWays solution = new DecodeWays();

    @Test
    void test() {
        assertThat(solution.numDecodings("226")).isEqualTo(3);
    }
}
