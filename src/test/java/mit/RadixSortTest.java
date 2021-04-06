package mit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class RadixSortTest {
    @Test
    void sort() {
        String[] input = new String[]{"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB", "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
        assertThat(RadixSort.sort(input), Matchers.is(new String[]{"BAR",
                "BIG",
                "BOX",
                "COW",
                "DIG",
                "DOG",
                "EAR",
                "FOX",
                "MOB",
                "NOW",
                "ROW",
                "RUG",
                "SEA",
                "TAB",
                "TAR",
                "TEA"
        }));
    }
}
