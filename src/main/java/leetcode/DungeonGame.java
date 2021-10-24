package leetcode;

/**
 * @author Tempo
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    dp[i][j] = Math.min(0, dungeon[i][j]);
                } else if (i == dungeon.length - 1) {
                    dp[i][j] = Math.min(0, dungeon[i][j] + dp[i][j + 1]);
                } else if (j == dungeon[0].length - 1) {
                    dp[i][j] = Math.min(0, dungeon[i][j] + dp[i + 1][j]);
                } else {
                    dp[i][j] = Math.min(0, dungeon[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }
        return Math.abs(dp[0][0]) + 1;
    }
}
