package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class DominoAndTrominoTilingTest {
    private DominoAndTrominoTiling dominoAndTrominoTiling;

    @BeforeEach
    void setUp() {
        this.dominoAndTrominoTiling = new DominoAndTrominoTiling();
    }

    @Test
    void numTilings() {
        Assertions.assertThat(this.dominoAndTrominoTiling.numTilings(4)).isEqualTo(11);
    }
}