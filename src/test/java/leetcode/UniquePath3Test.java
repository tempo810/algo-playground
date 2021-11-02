package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class UniquePath3Test {
    private final UniquePath3 solution = new UniquePath3();

    @Test
    void uniquePathsIII() {
        assertThat(solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, new int[]{0, 0, 2, -1}})).isEqualTo(2);
    }
}
