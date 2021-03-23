package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = Arrays.copyOf(digits, digits.length);
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] < 9) {
                result[i]++;
                break;
            }
            result[i] = 0;
        }

        if (result[0] == 0) {
            result = new int[result.length + 1];
            result[0] = 1;
        }
        return result;
    }
}
