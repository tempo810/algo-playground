package leetcode;

/**
 * @author tempo
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftLargest = new int[height.length];
        leftLargest[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftLargest[i] = Math.max(leftLargest[i - 1], height[i]);
        }
        int[] rightLargest = new int[height.length];
        int trappedWater = 0;
        rightLargest[rightLargest.length - 1] = height[height.length - 1];
        for (int i = rightLargest.length - 2; i > 0; i--) {
            rightLargest[i] = Math.max(rightLargest[i + 1], height[i]);
            int currentTrapped = Math.min(rightLargest[i], leftLargest[i]) - height[i];
            if (currentTrapped > 0) {
                trappedWater += currentTrapped;
            }
        }
        return trappedWater;
    }
}
