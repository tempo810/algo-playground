package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ArrayOfDoublePairsTest {
    private final ArrayOfDoublePairs solution = new ArrayOfDoublePairs();

    @Test
    void canReorderDoubled() {
        assertThat(solution.canReorderDoubled(new int[]{0, 0})).isTrue();
        assertThat(solution.canReorderDoubled(new int[]{2, 1, 2, 6})).isFalse();

    }
}
