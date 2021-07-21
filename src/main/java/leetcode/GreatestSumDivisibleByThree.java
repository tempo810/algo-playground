package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class GreatestSumDivisibleByThree {
    public int maxSumDivThree(int[] nums) {
        int[] sum = new int[3];
        for (int num : nums) {
            for (int i : Arrays.copyOf(sum, sum.length)) {
                sum[(i + num) % 3] = Math.max(sum[(i + num) % 3], i + num);
            }
        }
        return sum[0];
    }
}
