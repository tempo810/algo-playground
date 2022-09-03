package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class NumberWithConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        int[] dummy = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dummy[0] = i;
            dfs(dummy, 1, k, n, result);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void dfs(int[] temp, int position, int diff, int targetLength, List<Integer> result) {
        if (position == targetLength) {
            int value = 0;
            for (int j : temp) {
                value *= 10;
                value += j;
            }
            result.add(value);
        } else {
            int lastValue = temp[position - 1];

            int incrementValue = lastValue + diff;
            if (incrementValue < 10) {
                temp[position] = incrementValue;
                dfs(temp, position + 1, diff, targetLength, result);
            }

            int decrementValue = lastValue - diff;
            if (decrementValue >= 0 && decrementValue != incrementValue) {
                temp[position] = decrementValue;
                dfs(temp, position + 1, diff, targetLength, result);
            }
        }
    }
}
