package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CountingSortTest {
    @Test
    void sort() {
        int[] input = {2, 5, 3, 0, 2, 3, 0, 3};
        assertThat(CountingSort.sort(input, 5)).containsExactly(0, 0, 2, 2, 3, 3, 3, 5);
    }
}
