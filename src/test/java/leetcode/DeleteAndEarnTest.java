package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class DeleteAndEarnTest {
    private final DeleteAndEarn solution = new DeleteAndEarn();

    @Test
    void deleteAndEarn() {
        assertThat(solution.deleteAndEarn(new int[]{3, 4, 2})).isEqualTo(6);
    }
}
