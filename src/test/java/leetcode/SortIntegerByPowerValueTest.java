package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SortIntegerByPowerValueTest {
    private final SortIntegerByPowerValue solution = new SortIntegerByPowerValue();

    @Test
    void getKth() {
        assertThat(solution.getKth(12, 15, 2)).isEqualTo(13);
    }
}
