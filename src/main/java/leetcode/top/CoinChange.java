package leetcode.top;

import java.util.Arrays;

/**
 * @author tempo
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] numberOfCoins = new int[amount + 1];
        Arrays.fill(numberOfCoins, Integer.MIN_VALUE);
        for (int coin : coins) {
            if (coin <= amount) {
                numberOfCoins[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (numberOfCoins[i] != 1) {
                int minCoin = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++) {
                    int coin1 = numberOfCoins[j];
                    int coin2 = numberOfCoins[i - j];
                    if (coin1 > 0 && coin2 > 0) {
                        minCoin = Math.min(minCoin, coin1 + coin2);
                    }
                }
                numberOfCoins[i] = minCoin == Integer.MAX_VALUE ? -1 : minCoin;
            }
        }
        return numberOfCoins[amount];
    }
}
