package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class AverageShuffleTest {
    private final AverageShuffle solution = new AverageShuffle();

    @Test
    void test() {
        assertThat(solution.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2}))
                .containsExactlyInAnyOrder(2, 0, 4, 1, 2);
    }

}
