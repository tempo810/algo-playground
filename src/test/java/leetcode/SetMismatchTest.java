package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Tempo
 */
class SetMismatchTest {
    private final SetMismatch mismatch = new SetMismatch();

    @Test
    void test() {
        assertArrayEquals(mismatch.findErrorNums(new int[]{1, 2, 2, 4}), new int[]{2, 3});
    }
}
