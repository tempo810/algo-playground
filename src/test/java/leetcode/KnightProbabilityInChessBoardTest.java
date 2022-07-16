package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class KnightProbabilityInChessBoardTest {
    private final KnightProbabilityInChessBoard solution = new KnightProbabilityInChessBoard();

    @Test
    void knightProbability() {
        assertThat(solution.knightProbability(3, 2, 0, 0)).isEqualTo(0.06250);
    }
}
