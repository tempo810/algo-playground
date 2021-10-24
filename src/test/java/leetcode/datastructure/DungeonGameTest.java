package leetcode.datastructure;

import leetcode.DungeonGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class DungeonGameTest {
    private final DungeonGame solution = new DungeonGame();

    @Test
    void calculateMinimumHP() {
        assertThat(solution.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}})).isEqualTo(7);
    }
}
