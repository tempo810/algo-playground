package neetcode.blind75;

/**
 * @author tempo
 */
public class TrapWater {
    public int trap(int[] height) {
        int[] fromStart = new int[height.length];
        int[] fromEnd = new int[height.length];
        fromStart[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            fromStart[i] = Math.max(height[i], fromStart[i - 1]);
        }
        fromEnd[fromEnd.length - 1] = height[height.length - 1];
        for (int i = fromEnd.length - 2; i >= 0; i--) {
            fromEnd[i] = Math.max(fromEnd[i + 1], height[i]);
        }
        int trapped = 0;
        for (int i = 1; i < height.length - 1; i++) {
            trapped += Math.max(Math.min(fromStart[i - 1], fromEnd[i + 1]) - height[i], 0);
        }
        return trapped;
    }
}
