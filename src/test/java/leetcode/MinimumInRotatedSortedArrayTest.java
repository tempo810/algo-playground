package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MinimumInRotatedSortedArrayTest {
    private final MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();

    @Test
    void findMin() {
        assertThat(solution.findMin(new int[]{3, 4, 5, 1, 2})).isEqualTo(1);
    }

}
