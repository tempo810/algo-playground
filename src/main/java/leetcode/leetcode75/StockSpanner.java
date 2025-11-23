package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class StockSpanner {
    // index 0 = price, index 1 = span
    private final List<int[]> stockPrices;

    public StockSpanner() {
        this.stockPrices = new ArrayList<>();
        this.stockPrices.add(new int[]{0, 0});
    }

    public int next(int price) {
        int span = 1;
        int index = this.stockPrices.size() - 1;
        while (index >= 0 && this.stockPrices.get(index)[0] <= price) {
            final int lastSpan = this.stockPrices.get(index)[1];
            span += lastSpan;
            index -= lastSpan;
        }
        this.stockPrices.add(new int[]{price, span});
        return span;
    }
}
