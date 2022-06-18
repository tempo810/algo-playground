package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class WordFilterTest {

    @Test
    void testLookup() {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        assertThat(wordFilter.f("a", "e")).isEqualTo(0);
    }
}
