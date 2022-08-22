package leetcode;

/**
 * @author tempo
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (0b1010101010101010101010101010101 & n) == n;
    }
}
