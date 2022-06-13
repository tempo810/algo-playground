package leetcode;

import java.util.List;

/**
 * @author Tempo
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return search(0, 0, triangle, dp);
    }

    private int search(int row, int col, List<List<Integer>> triangle, Integer[][] dp) {
        if (dp[row][col] == null) {
            if (row == triangle.size() - 1) {
                dp[row][col] = triangle.get(row).get(col);
            } else {
                dp[row][col] = triangle.get(row).get(col) + Math.min(search(row + 1, col, triangle, dp),
                        search(row + 1, col + 1, triangle, dp));
            }
        }
        return dp[row][col];
    }
}
