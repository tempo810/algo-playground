package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ScoreOfParenthesesTest {
    private final ScoreOfParentheses solution = new ScoreOfParentheses();

    @Test
    void scoreOfParentheses() {
        assertThat(solution.scoreOfParentheses("(()(()))")).isEqualTo(6);
    }
}
