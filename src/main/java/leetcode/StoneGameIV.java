package leetcode;

/**
 * @author Tempo
 */
public class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        return canWin(n, dp);
    }

    private boolean canWin(int n, Boolean[] dp) {
        if (dp[n] == null) {
            double sqrt = Math.sqrt(n);
            double flooredSqrt = Math.floor(sqrt);
            if (flooredSqrt == sqrt) {
                dp[n] = true;
            } else {
                for (int i = (int) flooredSqrt; i >= 1; i--) {
                    dp[n] = !canWin(n - (i * i), dp);
                    if (dp[n]) {
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
