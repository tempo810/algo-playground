package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class QuickSortTest {

    @Test
    void sort() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        QuickSort.sort(arr, 0, arr.length - 1);
        assertThat(arr, Matchers.is(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}));

        int[] arr2 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        QuickSort.sortHoare(arr2, 0, arr2.length - 1);
        assertThat(arr2, Matchers.is(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}));
    }
}
