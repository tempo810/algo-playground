package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Tempo
 */
class MaxSubArrayTest {
    private final MaxSubArray solution = new MaxSubArray();

    @Test
    void test() {
        assertThat(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6));
    }
}
