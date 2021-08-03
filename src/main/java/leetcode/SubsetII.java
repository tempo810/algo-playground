package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int depth, List<Integer> partial, List<List<Integer>> results) {
        results.add(partial);
        for (int i = depth; i < nums.length; i++) {
            if (i > depth && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> next = new ArrayList<>(partial);
            next.add(nums[i]);
            dfs(nums, i + 1, next, results);
        }
    }
}
