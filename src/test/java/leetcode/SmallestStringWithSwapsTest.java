package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SmallestStringWithSwapsTest {
    private final SmallestStringWithSwaps solution = new SmallestStringWithSwaps();

    @Test
    void smallestStringWithSwaps() {
        assertThat(solution.smallestStringWithSwaps("vbjjxgdfnru", List.of(
                List.of(8, 6), List.of(3, 4), List.of(5, 2), List.of(5, 5), List.of(3, 5),
                List.of(7, 10), List.of(6, 0), List.of(10, 0), List.of(7, 1), List.of(4, 8), List.of(6, 2))))
                .isEqualTo("bdfgjjnuvrx");
    }
}
