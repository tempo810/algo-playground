package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class RussianDollEnvelopesTest {
    private final RussianDollEnvelopes solution = new RussianDollEnvelopes();

    @Test
    void maxEnvelopes() {
        assertThat(solution.maxEnvelopes(new int[][]{{6, 10}, {11, 14}, {6, 1}, {16, 14}, {13, 2}}), Matchers.is(3));
    }
}
