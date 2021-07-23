package leetcode.datastructure;

import leetcode.SubArraySumEqualK;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SubArraySumEqualKTest {
    private final SubArraySumEqualK solution = new SubArraySumEqualK();

    @Test
    void test() {
        assertThat(solution.subarraySum(new int[]{1, 2, 3}, 3)).isEqualTo(2);
    }
}
