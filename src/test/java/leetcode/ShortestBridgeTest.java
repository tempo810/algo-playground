package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class ShortestBridgeTest {
    private final ShortestBridge solution = new ShortestBridge();

    @Test
    void shortestBridge() {
        Assertions.assertThat(solution.shortestBridge(new int[][]{{0, 1}, {1, 0}})).isEqualTo(1);
    }
}
