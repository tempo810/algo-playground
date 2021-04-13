package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SelectionSortTest {

    @Test
    void asc() {
        int[] arr = new int[]{1, -1, 4, -1, 0, 5, 9, 10, 4};
        SelectionSort.asc(arr);
        assertThat(arr).containsExactly(-1, -1, 0, 1, 4, 4, 5, 9, 10);
    }
}
