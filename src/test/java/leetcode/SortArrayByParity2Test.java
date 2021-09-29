package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SortArrayByParity2Test {
    private final SortArrayByParity2 solution = new SortArrayByParity2();

    @Test
    void sortArrayByParityII() {
        assertThat(solution.sortArrayByParityII(new int[]{4, 2, 5, 7})).containsExactly(4, 5, 2, 7);
    }
}
