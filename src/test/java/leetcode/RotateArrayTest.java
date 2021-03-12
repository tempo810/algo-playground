package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class RotateArrayTest {
    private final RotateArray solution = new RotateArray();

    @Test
    void test() {
        solution.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

}
