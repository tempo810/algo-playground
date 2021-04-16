package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class RemoveAllAdjacentDuplicates2Test {
    private final RemoveAllAdjacentDuplicates2 solution = new RemoveAllAdjacentDuplicates2();

    @Test
    void removeDuplicates() {
        assertThat(solution.removeDuplicates("abcd", 2)).isEqualTo("abcd");
        assertThat(solution.removeDuplicates("deeedbbcccbdaa", 3)).isEqualTo("aa");
        assertThat(solution.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4)).isEqualTo("ybth");
    }
}
