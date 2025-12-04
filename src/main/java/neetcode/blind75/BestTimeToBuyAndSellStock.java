package neetcode.blind75;

/**
 * @author tempo
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuy = Integer.MAX_VALUE;
        int currentProfit = 0;
        for (int price : prices) {
            if (price > currentBuy) {
                currentProfit = Math.max(currentProfit, price - currentBuy);
            } else {
                maxProfit = Math.max(currentProfit, maxProfit);
                currentProfit = 0;
                currentBuy = price;
            }
        }

        return maxProfit;
    }
}
