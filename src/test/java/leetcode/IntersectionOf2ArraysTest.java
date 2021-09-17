package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class IntersectionOf2ArraysTest {
    private final IntersectionOf2Arrays solution = new IntersectionOf2Arrays();

    @Test
    void intersect() {
        assertThat(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).containsExactlyInAnyOrder(2, 2);
        assertThat(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).containsExactlyInAnyOrder(4, 9);
    }
}
