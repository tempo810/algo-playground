package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class GreatestSumDivisibleByThreeTest {
    private final GreatestSumDivisibleByThree solution = new GreatestSumDivisibleByThree();

    @Test
    void maxSumDivThree() {
        assertThat(solution.maxSumDivThree(new int[]{3, 6, 5, 1, 8})).isEqualTo(18);
    }
}
