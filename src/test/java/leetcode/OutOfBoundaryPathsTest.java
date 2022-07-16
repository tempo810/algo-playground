package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class OutOfBoundaryPathsTest {
    private final OutOfBoundaryPaths solution = new OutOfBoundaryPaths();

    @Test
    void findPaths() {
        Assertions.assertThat(solution.findPaths(1, 3, 3, 0, 1)).isEqualTo(12);
        Assertions.assertThat(solution.findPathsDp(8, 50, 23, 5, 26)).isEqualTo(914783380);
    }
}
