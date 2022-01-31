package leetcode;

/**
 * @author Tempo
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int customWealth = 0;
            for (int balance : account) {
                customWealth += balance;
            }
            max = Math.max(max, customWealth);
        }
        return max;
    }
}
