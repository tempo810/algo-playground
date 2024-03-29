package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class InsertionSortTest {
    @Test
    void sort() {
        int[] arr = new int[]{1, -1, 4, -1, 0, 5, 9, 10, 4};
        InsertionSort.asc(arr);
        assertThat(arr).containsExactly(-1, -1, 0, 1, 4, 4, 5, 9, 10);

        int[] arr2 = new int[]{1, -1, 4, -1, 0, 5, 9, 10, 4};
        InsertionSort.ascWithBinarySearch(arr2);
        assertThat(arr2).containsExactly(-1, -1, 0, 1, 4, 4, 5, 9, 10);

        InsertionSort.desc(arr);
        assertThat(arr).containsExactly(10, 9, 5, 4, 4, 1, 0, -1, -1);
    }
}
