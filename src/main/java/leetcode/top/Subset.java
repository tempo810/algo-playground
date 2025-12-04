package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            this.dfs(nums, i, 0, temp, result);
        }
        return result;
    }

    private void dfs(int[] nums, int length, int start, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        int remaining = length - temp.size();
        for (int i = start; i + remaining <= nums.length; i++) {
            temp.add(nums[i]);
            this.dfs(nums, length, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
