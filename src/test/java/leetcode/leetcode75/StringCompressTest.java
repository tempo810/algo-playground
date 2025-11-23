package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class StringCompressTest {
    private StringCompress stringCompress;

    @BeforeEach
    void setUp() {
        stringCompress = new StringCompress();
    }

    @Test
    void compress() {
        Assertions.assertThat(stringCompress.compress("abbbbbbbbbbbb".toCharArray())).isEqualTo(4);
    }
}