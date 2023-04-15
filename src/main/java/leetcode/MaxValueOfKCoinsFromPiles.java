package leetcode;

import java.util.List;

/**
 * @author tempo
 */
public class MaxValueOfKCoinsFromPiles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (List<Integer> pile : piles) {
            for (int i = 1; i < pile.size(); i++) {
                pile.set(i, pile.get(i) + pile.get(i - 1));
            }
        }
        int[][] dp = new int[piles.size()][k + 1];
        return dfs(piles, 0, k, dp);
    }

    private int dfs(List<List<Integer>> piles, int pileIndex, int k, int[][] dp) {
        if (pileIndex == piles.size()) {
            return -1;
        }

        if (dp[pileIndex][k] == 0) {
            List<Integer> pile = piles.get(pileIndex);
            for (int i = 0; i <= Math.min(k, pile.size()); i++) {
                if (i == k) {
                    dp[pileIndex][k] = Math.max(pile.get(i - 1), dp[pileIndex][k]);
                } else {
                    int next = dfs(piles, pileIndex + 1, k - i, dp);
                    if (next != -1) {
                        dp[pileIndex][k] = Math.max(i == 0 ? next : pile.get(i - 1) + next, dp[pileIndex][k]);
                    }
                }
            }
            if (dp[pileIndex][k] == 0) {
                dp[pileIndex][k] = -1;
            }
        }
        return dp[pileIndex][k];
    }
}
