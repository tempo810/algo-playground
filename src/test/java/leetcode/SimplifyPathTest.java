package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SimplifyPathTest {
    private final SimplifyPath solution = new SimplifyPath();

    @Test
    void simplifyPath() {
        assertThat(solution.simplifyPath("/a//b////c/d//././/..")).isEqualTo("/a/b/c");
        assertThat(solution.simplifyPath("/home//foo/")).isEqualTo("/home/foo");
    }
}
