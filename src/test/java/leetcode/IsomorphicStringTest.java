package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class IsomorphicStringTest {
    private final IsomorphicString solution = new IsomorphicString();

    @Test
    void isIsomorphic() {
        assertThat(solution.isIsomorphic("aa", "ab")).isFalse();
        assertThat(solution.isIsomorphic("bbbaaaba", "aaabbbba")).isFalse();
    }
}
