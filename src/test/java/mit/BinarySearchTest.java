package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class BinarySearchTest {

    @Test
    void search() {
        int[] arr = new int[]{1, 2, 4, 6, 7, 8, 10, 22, 50, 99};
        assertThat(BinarySearch.search(arr, 10)).isEqualTo(6);
        assertThat(BinarySearch.search(arr, 23)).isEqualTo(8);
        assertThat(BinarySearch.search(arr, 0)).isEqualTo(-1);
    }
}
