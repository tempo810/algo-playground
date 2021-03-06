package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class ShortEncodingOfWordsTest {
    private final ShortEncodingOfWords solution = new ShortEncodingOfWords();

    @Test
    void minimumLengthEncoding() {
        assertThat(solution.minimumLengthEncoding(new String[]{"time", "me", "bell"}), Matchers.is(10));
        assertThat(solution.minimumLengthEncodingTrieDemo(new String[]{"time", "atime", "btime"}), Matchers.is(5));
        assertThat(solution.minimumLengthEncodingTrieDemo(new String[]{"time", "me", "bell"}), Matchers.is(10));
    }
}
