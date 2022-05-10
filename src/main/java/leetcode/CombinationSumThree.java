package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), k, n, result);
        return result;
    }

    private void dfs(List<Integer> temp, int k, int remaining, List<List<Integer>> result) {
        if (temp.size() == k) {
            if (remaining == 0) {
                result.add(List.copyOf(temp));
            }
        } else {
            int start = temp.isEmpty() ? 1 : temp.get(temp.size() - 1) + 1;
            for (int i = start; i <= remaining && i <= 9; i++) {
                temp.add(i);
                dfs(temp, k, remaining - i, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
