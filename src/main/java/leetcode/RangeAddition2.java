package leetcode;

/**
 * @author Tempo
 */
public class RangeAddition2 {
    public int maxCount(int m, int n, int[][] ops) {
        int minWidth = m;
        int minHeight = n;
        for (int i = 0; i < ops.length; i++) {
            minWidth = Math.min(ops[i][0], minWidth);
            minHeight = Math.min(ops[i][1], minHeight);
        }
        return minWidth * minHeight;
    }
}
