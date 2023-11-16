package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author tempo
 */
class MaximumValueAtAGivenIndexINABoundedArrayTest {
    private final MaximumValueAtAGivenIndexINABoundedArray solution = new MaximumValueAtAGivenIndexINABoundedArray();

    @Test
    void maxValue() {
        Assertions.assertThat(solution.maxValue(6, 2, 931384943)).isEqualTo(155230825);
    }
}
