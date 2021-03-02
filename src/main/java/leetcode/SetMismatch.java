package leetcode;

/**
 * @author Tempo
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int[] ret = new int[2];
        for (int num : nums) {
            if (seen[num - 1]) {
                ret[0] = num;
            }
            seen[num - 1] = true;
        }

        for (int i = 0; i < seen.length; i++) {
            if (!seen[i]) {
                ret[1] = i + 1;
                break;
            }
        }
        return ret;
    }
}
