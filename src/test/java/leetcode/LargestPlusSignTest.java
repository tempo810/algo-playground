package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LargestPlusSignTest {
    private final LargestPlusSign solution = new LargestPlusSign();

    @Test
    void test() {
        assertThat(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}})).isEqualTo(2);
    }

}
