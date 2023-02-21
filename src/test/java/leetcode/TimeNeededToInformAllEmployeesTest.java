package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class TimeNeededToInformAllEmployeesTest {
    private final TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();

    @Test
    void numOfMinutes() {
        Assertions.assertThat(solution.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0})).isEqualTo(1);
    }
}
