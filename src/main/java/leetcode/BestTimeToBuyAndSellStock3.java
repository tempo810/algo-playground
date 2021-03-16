package leetcode;

/**
 * @author Tempo
 */
public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int firstTransactionWithStock = Integer.MIN_VALUE;
        int firstTransactionNoStock = 0;
        int secondTransactionWithStock = Integer.MIN_VALUE;
        int secondTransactionNoStock = 0;

        for (int price : prices) {
            firstTransactionWithStock = Math.max(firstTransactionWithStock, -price);
            firstTransactionNoStock = Math.max(firstTransactionNoStock, firstTransactionWithStock + price);
            secondTransactionWithStock = Math.max(secondTransactionWithStock, firstTransactionNoStock - price);
            secondTransactionNoStock = Math.max(secondTransactionNoStock, secondTransactionWithStock + price);
        }

        return secondTransactionNoStock;
    }
}
