package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class HeapSortTest {
    @Test
    void asc() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort.ascending(arr);
        assertThat(arr, Matchers.is(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}));
    }

    @Test
    void desc() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort.descending(arr);
        assertThat(arr, Matchers.is(new int[]{16, 14, 10, 9, 8, 7, 4, 3, 2, 1}));
    }
}
