package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class NumberOfIslandTest {
    private final NumberOfIsland solution = new NumberOfIsland();

    @Test
    void numIslandsUF() {
        char[][] land = {{'1', '0', '1'}, {'0', '1', '0'}, {'1', '0', '1'}};
        Assertions.assertThat(solution.numIslandsUF(land)).isEqualTo(5);
    }
}
