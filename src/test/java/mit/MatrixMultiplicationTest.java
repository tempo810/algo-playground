package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MatrixMultiplicationTest {
    @Test
    void test() {
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };

        int[][] b = new int[][]{
                {-1, -1, 2, 2},
                {-2, -2, 3, 3},
                {3, 3, -4, -4},
                {4, 4, -5, -5}
        };

        int[][] expected = new int[][]{
                {20, 20, -24, -24},
                {24, 24, -28, -28},
                {28, 28, -32, -32},
                {32, 32, -36, -36}
        };

        assertThat(MatrixMultiplication.multiplyBruteForce(a, b)).isDeepEqualTo(expected);
        assertThat(MatrixMultiplication.recursive(a, b, 0, 0, 0, 0, a.length)).isDeepEqualTo(expected);
        assertThat(MatrixMultiplication.strassen(a, b)).isDeepEqualTo(expected);
    }
}
