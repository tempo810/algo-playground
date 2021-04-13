package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class NextPermutationTest {
    private final NextPermutation solution = new NextPermutation();

    @Test
    void test() {
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        assertThat(nums).containsExactly(2, 1, 3);
    }
}
