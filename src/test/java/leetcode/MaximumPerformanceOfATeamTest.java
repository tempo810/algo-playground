package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author tempo
 */
class MaximumPerformanceOfATeamTest {
    private final MaximumPerformanceOfATeam solution = new MaximumPerformanceOfATeam();

    @Test
    void maxPerformance() {
        Assertions.assertThat(solution.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2)).isEqualTo(60);
    }
}
