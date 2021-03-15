package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class HeapTest {
    @Test
    void buildMaxHeap() {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap.buildMaxHeap(arr);
        assertThat(arr, Matchers.is(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}));

    }


    @Test
    void maxHeapify() {
        int[] arr = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap.maxHeapify(arr, 2);
        assertThat(arr, Matchers.is(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}));
    }

    @Test
    void testMaxHeapify() {
        int[] arr = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        Heap.maxHeapifyIterative(arr, 2);
        assertThat(arr, Matchers.is(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}));
    }
}
