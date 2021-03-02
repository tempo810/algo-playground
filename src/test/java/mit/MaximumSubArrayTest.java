package mit;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;


/**
 * @author tempo
 */
class MaximumSubArrayTest {
    private final int[] prices = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};

    @Test
    void bruteForce() {
        MatcherAssert.assertThat(MaximumSubArray.bruteForce(prices), is(new int[]{7, 11}));
    }

    @Test
    void recursion() {
        MatcherAssert.assertThat(MaximumSubArray.divideAndConquer(prices), is(new int[]{7, 11}));
    }

    @Test
    void linear() {
        MatcherAssert.assertThat(MaximumSubArray.linear(prices), is(new int[]{7, 11}));
    }
}
