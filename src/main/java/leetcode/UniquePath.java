package leetcode;

/**
 * @author tempo
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return uniquePaths(0, 0, dp);
    }

    private int uniquePaths(int m, int n, Integer[][] dp) {
        if (m == dp.length - 1 && n == dp[0].length - 1) {
            return 1;
        }

        Integer right = 0;
        Integer down = 0;
        if (n < dp[m].length - 1) {
            right = dp[m][n + 1];
            if (right == null) {
                right = uniquePaths(m, n + 1, dp);
                dp[m][n + 1] = right;
            }
        }

        if (m < dp.length - 1) {
            down = dp[m + 1][n];
            if (down == null) {
                down = uniquePaths(m + 1, n, dp);
                dp[m + 1][n] = down;
            }
        }
        return right + down;
    }
}
