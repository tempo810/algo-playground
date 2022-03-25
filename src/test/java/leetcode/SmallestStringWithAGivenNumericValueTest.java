package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class SmallestStringWithAGivenNumericValueTest {
    private final SmallestStringWithAGivenNumericValue solution = new SmallestStringWithAGivenNumericValue();

    @Test
    void getSmallestString() {
        Assertions.assertThat(solution.getSmallestString(5, 73)).isEqualTo("aaszz");
    }
}
