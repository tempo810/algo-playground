package leetcode;

/**
 * @author tempo
 */
public class ReverseBit {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 32; i > 0; i--) {
            result |= n << 32 - i >>> 31 << 32 - i;
        }
        return result;
    }
}
