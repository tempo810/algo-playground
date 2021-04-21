package leetcode;

import java.util.List;

/**
 * @author Tempo
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        return helper(0, 0, triangle, dp);
    }

    private int helper(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (dp[i][j] == null) {
            dp[i][j] = Math.min(helper(i + 1, j, triangle, dp), helper(i + 1, j + 1, triangle, dp)) + triangle.get(i).get(j);
        }
        return dp[i][j];
    }
}
