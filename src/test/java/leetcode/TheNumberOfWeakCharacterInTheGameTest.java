package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class TheNumberOfWeakCharacterInTheGameTest {
    private final TheNumberOfWeakCharacterInTheGame solution = new TheNumberOfWeakCharacterInTheGame();

    @Test
    void numberOfWeakCharacters() {
        assertThat(solution.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}})).isEqualTo(1);
    }
}
