package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ShortEncodingOfWordsTest {
    private final ShortEncodingOfWords solution = new ShortEncodingOfWords();

    @Test
    void minimumLengthEncoding() {
        assertThat(solution.minimumLengthEncoding(new String[]{"time", "me", "bell"})).isEqualTo(10);
        assertThat(solution.minimumLengthEncodingTrieDemo(new String[]{"time", "atime", "btime"})).isEqualTo(12);
        assertThat(solution.minimumLengthEncodingTrieDemo(new String[]{"time", "me", "bell"})).isEqualTo(10);
    }
}
