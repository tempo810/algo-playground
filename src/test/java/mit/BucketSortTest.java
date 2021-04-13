package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class BucketSortTest {
    @Test
    void sort() {
        float[] input = new float[]{0.79F, 0.13F, 0.16F, 0.64F, 0.39F, 0.20F, 0.89F, 0.53F, 0.71F, 0.42F};
        BucketSort.sort(input);
        assertThat(input).containsExactly(0.13F, 0.16F, 0.20F, 0.39F, 0.42F, 0.53F, 0.64F, 0.71F, 0.79F, 0.89F);
    }
}
