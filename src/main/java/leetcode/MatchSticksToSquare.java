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
        int[] edges = new int[4];
        return dfs(matchsticks, edges, 0, sum / 4);

    }

    private boolean dfs(int[] matchsticks, int[] edges, int current, int targetValue) {
        if (current == matchsticks.length) {
            for (int edge : edges) {
                if (edge != targetValue) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matchsticks[current] <= targetValue) {
                edges[i] += matchsticks[current];
                boolean result = dfs(matchsticks, edges, current + 1, targetValue);
                edges[i] -= matchsticks[current];
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean makesquareV2(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }

        if (matchsticks.length < 4 || sum == 0 || sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        boolean[] visited = new boolean[matchsticks.length];
        for (int i = 0; i < 4; i++) {
            if (!targetLength(matchsticks, visited, matchsticks.length - 1, sum / 4)) {
                return false;
            }
        }
        return true;
    }

    private boolean targetLength(int[] matchsticks, boolean[] visited, int endIndex, int targetValue) {
        for (int i = endIndex; i >= 0; i--) {
            if (!visited[i] && matchsticks[i] <= targetValue) {
                visited[i] = true;
                if (matchsticks[i] == targetValue) {
                    return true;
                }
                if (targetLength(matchsticks, visited, i - 1, targetValue - matchsticks[i])) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
