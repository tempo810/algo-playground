package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SearchInsertPositionTest {
    private final SearchInsertPositionSolution solution = new SearchInsertPositionSolution();

    @Test
    void searchInsert() {
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 0)).isEqualTo(0);
    }
}
