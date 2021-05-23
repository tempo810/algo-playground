package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class RandomizedSelectTest {

    @Test
    void randomizedSelect() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        assertThat(RandomizedSelect.randomizedSelect(arr, 0, arr.length - 1, 9)).isEqualTo(14);
        assertThat(RandomizedSelect.randomizedSelectIterative(arr, 0, arr.length - 1, 8)).isEqualTo(10);
    }
}
