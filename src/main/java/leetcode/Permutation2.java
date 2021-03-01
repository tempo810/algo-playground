package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Tempo
 */
public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, nums, results);
        return new ArrayList<>(new HashSet<>(results));
    }

    private void dfs(int start, int[] nums, List<List<Integer>> results) {
        if (start == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(result);
            return;
        }

        dfs(start + 1, nums, results);

        for (int i = start + 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                swap(nums, start, i);
                dfs(start + 1, nums, results);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
