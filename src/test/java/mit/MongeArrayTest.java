package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MongeArrayTest {
    private final int[][] positiveArray = new int[][]{
            {10, 17, 13, 28, 23},
            {17, 22, 16, 29, 23},
            {24, 28, 22, 34, 24},
            {11, 13, 6, 17, 7},
            {45, 44, 32, 37, 23},
            {36, 33, 19, 21, 6},
            {75, 66, 51, 53, 34}
    };

    private final int[][] negativeArray = new int[][]{
            {37, 23, 22, 32},
            {21, 6, 7, 10},
            {53, 34, 30, 31},
            {32, 13, 9, 6},
            {43, 21, 15, 8}
    };

    @Test
    void bruteForce() {
        assertThat(MongeArray.bruteForce(positiveArray)).isTrue();
        assertThat(MongeArray.bruteForce(negativeArray)).isFalse();
    }
}
