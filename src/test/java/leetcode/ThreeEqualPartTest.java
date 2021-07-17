package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ThreeEqualPartTest {
    private final ThreeEqualPart solution = new ThreeEqualPart();

    @Test
    void threeEqualParts() {
        assertThat(solution.threeEqualParts(new int[]{1, 0, 1, 0, 1})).containsExactly(0, 3);

    }
}
