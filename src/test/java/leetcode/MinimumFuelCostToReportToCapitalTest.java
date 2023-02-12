package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class MinimumFuelCostToReportToCapitalTest {
    private final MinimumFuelCostToReportToCapital solution = new MinimumFuelCostToReportToCapital();

    @Test
    void minimumFuelCost() {
        Assertions.assertThat(solution.minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2)).isEqualTo(7);
    }
}
