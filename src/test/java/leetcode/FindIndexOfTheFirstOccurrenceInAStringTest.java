package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class FindIndexOfTheFirstOccurrenceInAStringTest {
    private final FindIndexOfTheFirstOccurrenceInAString solution = new FindIndexOfTheFirstOccurrenceInAString();

    @Test
    void strStr() {
        Assertions.assertThat(solution.strStr("sadbutsad", "sad")).isEqualTo(0);
    }
}
