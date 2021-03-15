package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class HeapSortTest {
    @Test
    void sort() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort.heapSort(arr);
        assertThat(arr, Matchers.is(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}));
    }
}
