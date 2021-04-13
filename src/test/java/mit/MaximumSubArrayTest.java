package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author tempo
 */
class MaximumSubArrayTest {
    private final int[] prices = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};

    @Test
    void bruteForce() {
        assertThat(MaximumSubArray.bruteForce(prices)).containsExactly(7, 11);
    }

    @Test
    void recursion() {
        assertThat(MaximumSubArray.divideAndConquer(prices)).containsExactly(7, 11);
    }

    @Test
    void linear() {
        assertThat(MaximumSubArray.linear(prices)).containsExactly(7, 11);
    }
}
