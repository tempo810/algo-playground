package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ThreeSumClosestTest {
    private final ThreeSumClosest solution = new ThreeSumClosest();

    @Test
    void threeSumClosest() {
        assertThat(solution.threeSumClosest(new int[]{0, 2, 1, -3}, 1)).isEqualTo(-1);
        assertThat(solution.threeSumClosest(new int[]{0, 1, 2}, 0)).isEqualTo(3);
    }
}
