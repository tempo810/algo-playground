package leetcode;

/**
 * @author Tempo
 */
public class SumZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 1; i <= n / 2; i++) {
            result[i - 1] = i;
            result[result.length - i] = i * -1;
        }
        if (n % 2 == 1) {
            result[n / 2] = 0;
        }
        return result;
    }
}
