package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CherryPickupTest {
    private final CherryPickup solution = new CherryPickup();

    @Test
    void cherryPickup() {
        assertThat(solution.cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}})).isEqualTo(0);
        assertThat(solution.cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}})).isEqualTo(5);
    }
}
