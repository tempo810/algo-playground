package mit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Tempo
 */
class MatrixTest {
    @Test
    void test() {
        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {2, 3, 4, 5},
                {3, 4, 5, 6},
                {4, 5, 6, 7}
        };

        int[][] b = new int[][]{
                {1, 1, 2, 2},
                {2, 2, 3, 3},
                {3, 3, 4, 4},
                {4, 4, 5, 5}
        };
        Arrays.stream(Matrix.multiplyBruteForce(a, b)).forEach(row -> {
            System.out.println(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.toList()));
        });
    }
}
