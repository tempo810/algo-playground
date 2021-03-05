package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class DecodeWaysTest {
    private final DecodeWays solution = new DecodeWays();

    @Test
    void test() {
        assertThat(solution.numDecodings("226"), Matchers.is(3));
    }
}
