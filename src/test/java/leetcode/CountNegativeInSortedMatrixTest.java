package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class CountNegativeInSortedMatrixTest {
    private final CountNegativeInSortedMatrix solution = new CountNegativeInSortedMatrix();

    @Test
    void countNegatives() {
        Assertions.assertThat(solution.countNegatives(new int[][]{{7, -3}})).isEqualTo(1);
    }
}
