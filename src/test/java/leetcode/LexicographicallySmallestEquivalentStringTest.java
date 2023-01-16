package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class LexicographicallySmallestEquivalentStringTest {
    private final LexicographicallySmallestEquivalentString solution = new LexicographicallySmallestEquivalentString();

    @Test
    void smallestEquivalentString() {
        assertThat(solution.smallestEquivalentString("parker", "morris", "parser")).isEqualTo("makkek");

    }
}
