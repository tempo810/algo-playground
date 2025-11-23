package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class KthLargestElementInAnArrayTest {
    private KthLargestElementInAnArray kthLargestElementInAnArray;

    @BeforeEach
    void setUp() {
        this.kthLargestElementInAnArray = new KthLargestElementInAnArray();
    }

    @Test
    void findKthLargest() {
        Assertions.assertThat(this.kthLargestElementInAnArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
    }
}