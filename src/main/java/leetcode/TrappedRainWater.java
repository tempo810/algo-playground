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
}
