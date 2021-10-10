package leetcode;

/**
 * @author Tempo
 */
public class BitwiseAndNumberRange {
    public int rangeBitwiseAnd(int left, int right) {
        int hi = right;
        while (left < hi) {
            hi = hi & hi - 1;
        }
        return hi & left;
    }
}
