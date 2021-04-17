package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author Tempo
 */
class SortingVariableLengthIntegerTest {

    @Test
    void sort() {
        int[] arr = {1, 333, 92, 4155, 311, 4093, 55555, 22};
        SortingVariableLengthInteger.sort(arr, 5);
        assertThat(arr).containsExactly(1, 22, 92, 311, 333, 4093, 4155, 55555);
    }
}
