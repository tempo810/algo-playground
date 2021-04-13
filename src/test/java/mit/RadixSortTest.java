package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class RadixSortTest {
    @Test
    void sort() {
        String[] input = new String[]{"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB", "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};
        assertThat(RadixSort.sort(input)).containsExactly(
                "BAR",
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
                "TEA");
    }
}
