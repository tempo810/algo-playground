package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class DecodeStringTest {
    private DecodeString decodeString;

    @BeforeEach
    void setUp() {
        this.decodeString = new DecodeString();
    }

    @Test
    void decodeString() {
        Assertions.assertThat(this.decodeString.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
    }
}