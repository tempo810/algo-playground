package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] partial = new boolean[nums.length];
        int[] current = new int[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, partial, current, 0, results);
        return results;
    }

    private void permute(int[] nums, boolean[] partial, int[] current, int d, List<List<Integer>> results) {
        if (d == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int j : current) {
                result.add(j);
            }
            results.add(result);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!partial[i]) {
                partial[i] = true;
                current[d] = nums[i];
                permute(nums, partial, current, d + 1, results);
                partial[i] = false;
            }
        }
    }
}
