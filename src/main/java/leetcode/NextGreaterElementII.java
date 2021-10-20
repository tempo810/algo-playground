package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Tempo
 */
public class NextGreaterElementII {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> greatElements = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                greatElements.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ret = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            ret[j] = greatElements.getOrDefault(nums1[j], -1);
        }
        return ret;
    }
}
