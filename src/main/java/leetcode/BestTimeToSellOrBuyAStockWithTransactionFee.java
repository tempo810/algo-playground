package leetcode;

/**
 * @author tempo
 */
public class BestTimeToSellOrBuyAStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int prevSell = 0;
        int prevBuy = 0;
        int endSell = 0;
        int endBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            prevBuy = endBuy;
            endBuy = Math.max(endBuy, prevSell - price - fee);
            prevSell = endSell;
            endSell = Math.max(endSell, prevBuy + price);
        }
        return endSell;
    }
}
