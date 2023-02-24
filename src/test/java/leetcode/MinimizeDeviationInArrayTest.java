package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author tempo
 */
class MinimizeDeviationInArrayTest {
    private final MinimizeDeviationInArray solution = new MinimizeDeviationInArray();

    @Test
    void minimumDeviation() {
        Assertions.assertThat(solution.minimumDeviation(new int[]{10, 4, 3})).isEqualTo(2);
    }
}
