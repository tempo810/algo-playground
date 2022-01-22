package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class StoneGameIVTest {
    private final StoneGameIV solution = new StoneGameIV();

    @Test
    void winnerSquareGame() {
        assertThat(solution.winnerSquareGame(3)).isEqualTo(true);
        assertThat(solution.winnerSquareGame(8)).isEqualTo(true);
    }
}
