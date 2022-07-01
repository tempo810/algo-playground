package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class QueueReconstructionByHeightTest {
    private final QueueReconstructionByHeight solution = new QueueReconstructionByHeight();

    @Test
    void reconstructQueue() {
        assertThat(solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}))
                .isDeepEqualTo(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
    }
}
