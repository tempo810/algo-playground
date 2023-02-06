package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class ShuffleTheArrayTest {
    private final ShuffleTheArray solution = new ShuffleTheArray();

    @Test
    void shuffle() {
        Assertions.assertThat(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)).containsExactly(2, 3, 5, 4, 1, 7);
    }
}
