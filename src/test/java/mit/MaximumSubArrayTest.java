package mit;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;


/**
 * @author tempo
 */
class MaximumSubArrayTest {
    @Test
    void bruteForce() {
        int[] prices = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        MatcherAssert.assertThat(MaximumSubArray.bruteForce(prices), is(new int[]{7, 11}));
    }
}
