package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class WordLadderIITest {
    private final WordLadderII solution = new WordLadderII();

    @Test
    void findLadders() {
        assertThat(solution.findLadders("hit", "dot", List.of("hot", "dot"))).isEqualTo(List.of(
                List.of("hot", "dot")));
    }
}
