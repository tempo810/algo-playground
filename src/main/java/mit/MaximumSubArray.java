package mit;

/**
 * @author tempo
 */
public class MaximumSubArray {
    public static int[] bruteForce(int[] prices) {
        int maxEarning = Integer.MIN_VALUE;
        int[] days = new int[2];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxEarning) {
                    days[0] = i;
                    days[1] = j;
                    maxEarning = prices[j] - prices[i];
                }
            }
        }
        return days;
    }
}
