package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class FindPeakElementTest {
    private final FindPeakElement solution = new FindPeakElement();

    @Test
    void findPeakElement() {
        assertThat(solution.findPeakElement(new int[]{1, 2, 3, 1})).isEqualTo(2);
    }
}
