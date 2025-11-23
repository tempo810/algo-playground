package leetcode.leetcode75;

/**
 * @author tempo
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int current = 1;
        int nextPow = 0;
        while (current <= n) {
            if (current == Math.pow(2, nextPow)) {
                nextPow++;
                result[current] = 1;
            } else {
                int lookup = current - (int) Math.pow(2, nextPow - 1);
                result[current] = 1 + result[lookup];
            }
            current++;
        }
        return result;
    }
}
