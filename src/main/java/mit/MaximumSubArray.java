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

    public static int[] divideAndConquer(int[] prices) {
        int[] delta = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            delta[i - 1] = prices[i] - prices[i - 1];
        }
        Result result = solve(0, delta.length - 1, delta);
        return new int[]{result.low, result.high + 1};
    }

    private static Result solve(int low, int high, int[] delta) {
        if (low == high) {
            return new Result(low, high, delta[low]);
        }

        int mid = (low + high) / 2;
        Result left = solve(low, mid, delta);
        Result right = solve(mid + 1, high, delta);

        int leftSum = Integer.MIN_VALUE;
        int maxLeft = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += delta[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += delta[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        if (left.sum >= right.sum && left.sum >= leftSum + rightSum) {
            return left;
        } else if (right.sum >= left.sum && right.sum >= leftSum + rightSum) {
            return right;
        }
        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }

    public static int[] linear(int[] prices) {
        int[] deltas = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            deltas[i] = prices[i + 1] - prices[i];
        }

        int currentMax = 0;
        int currentStart = -1;
        int globalMax = 0;
        int globalStart = -1;
        int globalEnd = -1;
        for (int i = 0; i < deltas.length; i++) {
            currentMax = Math.max(0, currentMax + deltas[i]);
            if (currentMax == 0) {
                currentStart = i + 1;
            }
            if (currentMax > globalMax) {
                globalMax = currentMax;
                globalStart = currentStart;
                globalEnd = i;
            }
        }
        return new int[]{globalStart, globalEnd + 1};
    }

    private static class Result {
        private final int low;
        private final int high;
        private final int sum;

        private Result(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
}
