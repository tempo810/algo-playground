package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class FindKClosestElementsTest {
    private final FindKClosestElements solution = new FindKClosestElements();

    @Test
    void findClosestElements() {
        Assertions.assertThat(solution.findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)).containsExactly(10);
        Assertions.assertThat(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)).containsExactly(1, 2, 3, 4);
    }
}
