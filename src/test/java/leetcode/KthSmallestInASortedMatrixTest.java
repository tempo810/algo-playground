package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class KthSmallestInASortedMatrixTest {
    private final KthSmallestInASortedMatrix solution = new KthSmallestInASortedMatrix();

    @Test
    void kthSmallest() {
        Assertions.assertThat(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8)).isEqualTo(13);
    }
}
