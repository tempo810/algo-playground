package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class SuccessfulPairsOfSpellAndPotionsTest {

    private SuccessfulPairsOfSpellAndPotions successfulPairsOfSpellAndPotions;

    @BeforeEach
    void setUp() {
        this.successfulPairsOfSpellAndPotions = new SuccessfulPairsOfSpellAndPotions();
    }

    @Test
    void successfulPairs() {
        Assertions.assertThat(this.successfulPairsOfSpellAndPotions.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)).isEqualTo(new int[]{4, 0, 3});
    }
}