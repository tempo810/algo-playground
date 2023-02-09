package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class DistinctNamesTest {
    private final DistinctNames solution = new DistinctNames();

    @Test
    void distinctNames() {
        assertThat(solution.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"})).isEqualTo(6);
    }
}
