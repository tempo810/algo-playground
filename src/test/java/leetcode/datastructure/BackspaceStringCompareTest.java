package leetcode.datastructure;

import leetcode.BackspaceStringCompare;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class BackspaceStringCompareTest {
    private final BackspaceStringCompare solution = new BackspaceStringCompare();

    @Test
    void backspaceCompare() {
        Assertions.assertThat(solution.backspaceCompare("ab##", "c#d#")).isTrue();
    }
}
