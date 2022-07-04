package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CandyTest {
    private final Candy solution = new Candy();

    @Test
    void candy() {
        assertThat(solution.candy(new int[]{1, 0, 2})).isEqualTo(5);
    }
}
