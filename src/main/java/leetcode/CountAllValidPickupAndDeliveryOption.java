package leetcode;

/**
 * @author Tempo
 */
public class CountAllValidPickupAndDeliveryOption {
    public int countOrders(int n) {
        long result = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            result *= ((long) n * 2 - 1) * n % mod;
        }
        return (int) result;
    }
}
