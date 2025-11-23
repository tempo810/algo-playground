package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class MaximumAverageSubarray1Test {
    private MaximumAverageSubarray1 subarray1;

    @BeforeEach
    void setUp() {
        subarray1 = new MaximumAverageSubarray1();
    }

    @Test
    void findMaxAverage() {
        Assertions.assertThat(this.subarray1.findMaxAverage(new int[]{-1}, 1)).isEqualTo(-1);
    }
}