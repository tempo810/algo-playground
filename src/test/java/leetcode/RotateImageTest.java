package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class RotateImageTest {
    private final RotateImage solution = new RotateImage();

    @Test
    void rotate() {
        final int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        assertThat(matrix).isEqualTo(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
    }
}
