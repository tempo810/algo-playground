package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class RussianDollEnvelopesTest {
    private final RussianDollEnvelopes solution = new RussianDollEnvelopes();

    @Test
    void maxEnvelopes() {
        assertThat(solution.maxEnvelopes(new int[][]{{6, 10}, {11, 14}, {6, 1}, {16, 14}, {13, 2}})).isEqualTo(3);
    }
}
