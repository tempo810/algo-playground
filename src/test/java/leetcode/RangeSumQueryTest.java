package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class RangeSumQueryTest {

    @Test
    void sumRange() {
        var bit = new RangeSumQuery(new int[]{1, 3, 5});
        assertThat(bit.sumRange(0, 2)).isEqualTo(9);
        bit.update(1, 2);
        assertThat(bit.sumRange(0, 2)).isEqualTo(8);

    }
}
