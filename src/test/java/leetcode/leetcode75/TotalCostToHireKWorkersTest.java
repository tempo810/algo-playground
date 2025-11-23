package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class TotalCostToHireKWorkersTest {
    private TotalCostToHireKWorkers totalCostToHireKWorkers;

    @BeforeEach
    void setUp() {
        this.totalCostToHireKWorkers = new TotalCostToHireKWorkers();
    }

    @Test
    void totalCost() {
//        Assertions.assertThat(this.totalCostToHireKWorkers.totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2)).isEqualTo(423);
//        Assertions.assertThat(this.totalCostToHireKWorkers.totalCost(new int[]{17,12,2,200,8}, 1, 3)).isEqualTo(2);
        Assertions.assertThat(this.totalCostToHireKWorkers.totalCost(new int[]{28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34}, 32, 12)).isEqualTo(1407);
    }
}