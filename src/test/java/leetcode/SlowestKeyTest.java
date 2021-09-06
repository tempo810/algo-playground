package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SlowestKeyTest {
    private final SlowestKey solution = new SlowestKey();

    @Test
    void slowestKey() {
        assertThat(solution.slowestKey(new int[]{23, 34, 43, 59, 62, 80, 83, 92, 97}, "qgkzzihfc")).isEqualTo('q');
    }
}
