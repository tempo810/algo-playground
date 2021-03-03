package leetcode;

/**
 * @author Tempo
 */
public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int prevSell = 0;
        int prevBuy = 0;
        int endSell = 0;
        int endBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            prevBuy = endBuy;
            endBuy = Math.max(endBuy, prevSell - price);
            prevSell = endSell;
            endSell = Math.max(endSell, prevBuy + price);
        }
        return endSell;
    }
}
