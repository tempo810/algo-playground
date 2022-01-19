package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CanPlaceFlowerTest {
    private final CanPlaceFlower solution = new CanPlaceFlower();

    @Test
    void canPlaceFlowers() {
        assertThat(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)).isTrue();
        assertThat(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)).isFalse();
        assertThat(solution.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1)).isTrue();
    }
}
