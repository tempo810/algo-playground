package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class PalindromePairsTest {
    private final PalindromePairs solution = new PalindromePairs();

    @Test
    void test() {
        solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
    }
}
