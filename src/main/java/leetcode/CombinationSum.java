package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author Tempo
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> partial = new Stack<>();
        findSum(candidates, 0, target, partial, result);
        return result;
    }

    private void findSum(int[] candidates, int index, int remainingSum, Stack<Integer> partial, List<List<Integer>> result) {
        if (index == candidates.length) {
            return;
        }

        int candidate = candidates[index];
        if (candidate > remainingSum) {
            return;
        }

        int dividend = remainingSum / candidate;
        if (remainingSum % candidate == 0) {
            List<Integer> currentResult = new ArrayList<>(partial);
            for (int i = 0; i < dividend; i++) {
                currentResult.add(candidate);
            }
            result.add(currentResult);
        }

        int current = 1;
        for (; current <= dividend && candidate * current < remainingSum; current++) {
            partial.add(candidate);
            findSum(candidates, index + 1, remainingSum - candidate * current, partial, result);
        }

        for (int i = 1; i < current; i++) {
            partial.pop();
        }

        findSum(candidates, index + 1, remainingSum, partial, result);
    }

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
