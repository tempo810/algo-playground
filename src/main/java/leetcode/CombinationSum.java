package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Tempo
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] ints = Arrays.stream(candidates).sorted().distinct().toArray();
        Deque<Integer> partial = new ArrayDeque<>();
        List<List<Integer>> results = new ArrayList<>();
        combinationSum(ints, partial, results, 0, target);
        return results;
    }

    private void combinationSum(int[] ints, Deque<Integer> partials, List<List<Integer>> results, int start, int target) {
        if (target < 0 || start == ints.length) {
            return;
        }

        if (target == 0) {
            results.add(new ArrayList<>(partials));
        } else {
            if (target - ints[start] >= 0) {
                partials.push(ints[start]);
                combinationSum(ints, partials, results, start, target - ints[start]);
                partials.pop();
            }
            combinationSum(ints, partials, results, start + 1, target);
        }
    }
}
