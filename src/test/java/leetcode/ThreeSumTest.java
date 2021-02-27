package leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Tempo
 */
class ThreeSumTest {
    private final ThreeSum solution = new ThreeSum();

    @Test
    void threeSum() {
        assertThat(solution.threeSum(new int[]{-1,0,1,2,-1,-4}), is(true));
    }
}
