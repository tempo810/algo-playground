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
        assertThat(solution.makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3})).isTrue();
    }
}
