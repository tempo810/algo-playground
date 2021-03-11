package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return helper(coins.length - 1, amount, coins);
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            if (coin <= amount) {
                dp[coin] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                int currentMax = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
                        currentMax = Math.min(dp[i - coin] + 1, currentMax);
                    }
                }
                dp[i] = currentMax;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChangeDp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        return coinChangeDp(coins, amount, dp);
    }

    private int coinChangeDp(int[] coins, int amount, int[] dp) {
        if (dp[amount] == Integer.MAX_VALUE) {
            int total = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount > coin) {
                    int subProblemCoin = coinChangeDp(coins, amount - coin, dp);
                    if (subProblemCoin != -1) {
                        total = Math.min(subProblemCoin + 1, total);
                    }
                } else {
                    if (amount - coin == 0) {
                        total = 1;
                    }
                    break;
                }
            }
            dp[amount] = total == Integer.MAX_VALUE ? -1 : total;
        }
        return dp[amount];
    }

    private int helper(int index, int amount, int[] coins) {
        if (index == -1) {
            return -1;
        }
        int maxNumberOfCoin = amount / coins[index];
        int remaining = maxNumberOfCoin == 0 ? amount : amount % coins[index];
        if (remaining == 0) {
            return maxNumberOfCoin;
        }
        int result = Integer.MAX_VALUE;
        for (int i = maxNumberOfCoin; i >= 0; i--) {
            int subProblemNumber = helper(index - 1, remaining + (maxNumberOfCoin - i) * coins[index], coins);
            if (subProblemNumber != -1) {
                result = Math.min(result, subProblemNumber + i);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
