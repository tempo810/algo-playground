package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author tempo
 */
class NextPermutationTest {
    private final NextPermutation solution = new NextPermutation();

    @Test
    void test() {
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        assertThat(nums, is(new int[]{2, 1, 3}));
    }
}
