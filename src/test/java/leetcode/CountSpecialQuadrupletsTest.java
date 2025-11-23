package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class CountSpecialQuadrupletsTest {
    private CountSpecialQuadruplets countSpecialQuadruplets;

    @BeforeEach
    void setUp() {
        countSpecialQuadruplets = new CountSpecialQuadruplets();
    }

    @Test
    void countQuadruplets() {
        Assertions.assertEquals(4, countSpecialQuadruplets.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
    }
}