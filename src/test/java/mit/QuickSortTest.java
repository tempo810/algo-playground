package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class QuickSortTest {

    @Test
    void sort() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        QuickSort.sort(arr, 0, arr.length - 1);
        assertThat(arr).containsExactly(1, 2, 3, 4, 7, 8, 9, 10, 14, 16);

        int[] arr2 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        QuickSort.sortHoare(arr2, 0, arr2.length - 1);
        assertThat(arr2).containsExactly(1, 2, 3, 4, 7, 8, 9, 10, 14, 16);

        int[] arr3 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        QuickSort.sortHoareTailRecursion(arr3, 0, arr3.length - 1);
        assertThat(arr3).containsExactly(1, 2, 3, 4, 7, 8, 9, 10, 14, 16);
    }
}
