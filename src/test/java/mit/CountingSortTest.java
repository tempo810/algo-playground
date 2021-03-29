package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class CountingSortTest {
    @Test
    void sort() {
        int[] input = {2, 5, 3, 0, 2, 3, 0, 3};
        assertThat(CountingSort.sort(input, 5), Matchers.is(new int[]{0, 0, 2, 2, 3, 3, 3, 5}));
    }
}
