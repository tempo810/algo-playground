package leetcode.datastructure;

import leetcode.FindDuplicatedSortedArray;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class FindDuplicatedSortedArrayTest {
    private final FindDuplicatedSortedArray solution = new FindDuplicatedSortedArray();

    @Test
    void containsDuplicated() {
        assertThat(solution.containsDuplicated(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8})).isFalse();
        assertThat(solution.containsDuplicated(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8, 9})).isFalse();
        assertThat(solution.containsDuplicated(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 9})).isTrue();
    }
}
