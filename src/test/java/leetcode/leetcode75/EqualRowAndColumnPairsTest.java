package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class EqualRowAndColumnPairsTest {
    private EqualRowAndColumnPairs equalRowAndColumnPairs;

    @BeforeEach
    void setUp() {
        equalRowAndColumnPairs = new EqualRowAndColumnPairs();
    }

    @Test
    void equalPairs() {
        Assertions.assertThat(equalRowAndColumnPairs.equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}})).isEqualTo(1);
    }
}