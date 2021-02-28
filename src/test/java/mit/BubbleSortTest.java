package mit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tempo
 */
class BubbleSortTest {

    @Test
    void bubbleSort() {
        int[] arr = new int[]{1, -1, 4, -1, 0, 5, 9, 10, 4};
        BubbleSort.bubbleSort(arr);
        assertThat(arr, is(new int[]{-1, -1, 0, 1, 4, 4, 5, 9, 10}));
    }
}
