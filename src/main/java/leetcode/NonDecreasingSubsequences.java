package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tempo
 */
public class NonDecreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, result, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, Set<List<Integer>> result, List<Integer> tmp) {
        if (index == nums.length) {
            if (tmp.size() >= 2) {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        dfs(nums, index + 1, result, tmp);
        if (tmp.isEmpty() || nums[index] >= tmp.get(tmp.size() - 1)) {
            tmp.add(nums[index]);
            dfs(nums, index + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
