package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class TrappedRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int trappedVolume = 0;
        for (int i = 0; i < height.length; i++) {
            int current = height[i];
            while (!stack.isEmpty() && current > height[stack.peek()]) {
                int bottomHeight = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    int dist = i - left - 1;
                    int edgeHeight = Math.min(current, height[i]);
                    trappedVolume += dist * (edgeHeight - bottomHeight);
                }
            }
            stack.add(i);
        }
        return trappedVolume;
    }

    public int trapV2(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] leftMaxPrefix = new int[height.length];
        leftMaxPrefix[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxPrefix[i] = Math.max(leftMaxPrefix[i - 1], height[i]);
        }

        int[] rightMaxPrefix = new int[height.length];
        rightMaxPrefix[rightMaxPrefix.length - 1] = height[height.length - 1];
        for (int i = rightMaxPrefix.length - 2; i >= 0; i--) {
            rightMaxPrefix[i] = Math.max(rightMaxPrefix[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMaxPrefix[i], rightMaxPrefix[i]) - height[i];
        }
        return result;
    }
}
