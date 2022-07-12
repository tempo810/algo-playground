package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MatchSticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }

        if (matchsticks.length < 4 || sum == 0 || sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        int[] lengths = new int[4];
        return dfs2(matchsticks.length - 1, matchsticks, lengths, sum / 4);
    }

    private boolean dfs2(int index, int[] matchsticks, int[] lengths, int target) {
        if (index == -1) {
            return true;
        }
        for (int j = 0; j < lengths.length; j++) {
            if (lengths[j] + matchsticks[index] <= target) {
                lengths[j] += matchsticks[index];
                if (dfs2(index - 1, matchsticks, lengths, target)) {
                    return true;
                }
                lengths[j] -= matchsticks[index];
            }
        }
        return false;
    }
}
