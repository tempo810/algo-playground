package leetcode;

/**
 * @author Tempo
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        int max = 1162261467;
        if (n <= 0 || n > max) {
            return false;
        }
        return max % n == 0;
    }
}
