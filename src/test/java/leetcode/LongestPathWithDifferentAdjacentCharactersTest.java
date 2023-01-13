package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author tempo
 */
class LongestPathWithDifferentAdjacentCharactersTest {
    private final LongestPathWithDifferentAdjacentCharacters solution = new LongestPathWithDifferentAdjacentCharacters();

    @Test
    void longestPath() {
        assertThat(solution.longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe")).isEqualTo(3);
    }
}
