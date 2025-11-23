package leetcode.leetcode75;

/**
 * @author tempo
 */
public class BestTimeToSellAStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int currentBuyPrice = Integer.MAX_VALUE;
        int currentMaxProfit = 0;
        int totalMaxProfit = 0;
        for (int price : prices) {
            if (price < currentBuyPrice) { // reset
                totalMaxProfit += currentMaxProfit;
                currentBuyPrice = price;
                currentMaxProfit = 0;
            } else { //
                int currentProfit = price - currentBuyPrice - fee;
                if (currentProfit > currentMaxProfit) {
                    currentMaxProfit = currentProfit;
                } else if (currentProfit + fee < currentMaxProfit) {
                    currentBuyPrice = price;
                    totalMaxProfit += currentMaxProfit;
                    currentMaxProfit = 0;
                }
            }
        }
        return totalMaxProfit + currentMaxProfit;
    }
}
