package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class ValidStackSequencesTest {
    private final ValidStackSequences solution = new ValidStackSequences();

    @Test
    void validateStackSequences() {
        Assertions.assertThat(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1})).isTrue();
    }
}
