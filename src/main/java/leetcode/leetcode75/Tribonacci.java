package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class Tribonacci {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] cache = new int[3];
        Arrays.fill(cache, 0);
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            int result = cache[0] + cache[1] + cache[2];
            cache[i % 3] = result;
        }

        return cache[0] + cache[1] + cache[2];
    }
}
