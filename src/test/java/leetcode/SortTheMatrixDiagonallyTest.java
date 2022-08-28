package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class SortTheMatrixDiagonallyTest {
    private final SortTheMatrixDiagonally solution = new SortTheMatrixDiagonally();

    @Test
    @Disabled
    void diagonalSort() {
//        Assertions.assertThat(solution.diagonalSort(new int[][]{{2,2}, {1,1}})).isEqualTo(new int[][]{{1,2}, {1, 2}});
        Assertions.assertThat(solution.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})).isEqualTo(new int[][]{{1, 1, 1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3}});
    }
}
