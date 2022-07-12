package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MatchSticksToSquareTest {
    private final MatchSticksToSquare solution = new MatchSticksToSquare();

    @Test
    void makesquare() {
        assertThat(solution.makesquare(new int[]{13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8})).isTrue();
    }
}
