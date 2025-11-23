package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class NumberOfProvincesTest {
    private NumberOfProvinces numberOfProvinces;

    @BeforeEach
    void setUp() {
        this.numberOfProvinces = new NumberOfProvinces();
    }

    @Test
    void findCircleNum() {
        Assertions.assertThat(this.numberOfProvinces.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}})).isEqualTo(1);
    }
}