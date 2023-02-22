package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class CapacityToShipPackagesWithinDDaysTest {
    private final CapacityToShipPackagesWithinDDays solution = new CapacityToShipPackagesWithinDDays();

    @Test
    void shipWithinDays() {
        Assertions.assertThat(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)).isEqualTo(15);
    }
}
