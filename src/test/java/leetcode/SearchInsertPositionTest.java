package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class SearchInsertPositionTest {
    private final SearchInsertPositionSolution solution = new SearchInsertPositionSolution();

    @Test
    void searchInsert() {
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 5), Matchers.is(2));
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 2), Matchers.is(1));
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 7), Matchers.is(4));
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 0), Matchers.is(0));
    }
}
