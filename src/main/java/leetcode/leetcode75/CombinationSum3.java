package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) { // k = number of element, n = sum
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findCombination(1, k, n, current, result);
        return result;
    }

    private void findCombination(int startingNum, int remainingElements, int remainingSum, List<Integer> current, List<List<Integer>> result) {
        if (remainingElements == 0 && remainingSum == 0) {
            result.add(List.copyOf(current));
            return;
        }
        for (int i = startingNum; i <= 9; i++) {
            if (i <= remainingSum) {
                current.add(i);
                findCombination(i + 1, remainingElements - 1, remainingSum - i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
