package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class NumberOfClosedIslandTest {
    private final NumberOfClosedIsland numberOfClosedIsland = new NumberOfClosedIsland();

    @Test
    void closedIsland() {
        assertThat(numberOfClosedIsland.closedIsland2(new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}})).isEqualTo(2);
    }
}
