package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class KMissingPositiveNumberTest {
    private final KMissingPositiveNumber solution = new KMissingPositiveNumber();

    @Test
    void findKthPositive() {
        Assertions.assertThat(solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5)).isEqualTo(9);
    }
}
