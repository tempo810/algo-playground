package mit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Tempo
 */
class BinarySearchTest {

    @Test
    void search() {
        int[] arr = new int[]{1, 2, 4, 6, 7, 8, 10, 22, 50, 99};
        assertThat(BinarySearch.search(arr, 10), is(6));
        assertThat(BinarySearch.search(arr, 23), is(8));
        assertThat(BinarySearch.search(arr, 0), is(-1));
    }
}
