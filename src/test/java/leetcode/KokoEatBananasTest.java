package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class KokoEatBananasTest {
    private final KokoEatBananas solution = new KokoEatBananas();

    @Test
    void minEatingSpeed() {
        assertThat(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8)).isEqualTo(4);
        assertThat(solution.minEatingSpeed(new int[]{312884470}, 312884469)).isEqualTo(2);
    }
}
