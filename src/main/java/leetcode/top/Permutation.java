package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        this.dfs(result, picked, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, boolean[] picked, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                picked[i] = true;
                temp.add(nums[i]);
                dfs(result, picked, temp, nums);
                temp.remove(temp.size() - 1);
                picked[i] = false;
            }
        }
    }
}
