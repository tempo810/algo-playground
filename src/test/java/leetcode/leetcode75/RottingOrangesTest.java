package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class RottingOrangesTest {
    private RottingOranges rottingOranges;

    @BeforeEach
    void setUp() {
        this.rottingOranges = new RottingOranges();
    }

    @Test
    void orangesRotting() {
        Assertions.assertThat(this.rottingOranges.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})).isEqualTo(4);
    }
}