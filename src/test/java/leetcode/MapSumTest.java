package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MapSumTest {
    @Test
    void count() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertThat(mapSum.sum("ap")).isEqualTo(3);
    }
}
