package leetcode.datastructure;

import leetcode.TitleToNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class TitleToNumberTest {
    private final TitleToNumber solution = new TitleToNumber();

    @Test
    void titleToNumber() {
        assertThat(solution.titleToNumber("ZY")).isEqualTo(701);
    }
}
