package leetcode;

import java.util.Stack;

/**
 * @author tempo
 */
public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int value : popped) {
            while (stack.isEmpty() || stack.peek() != value) {
                if (pushedIndex == pushed.length) {
                    return false;
                }
                stack.push(pushed[pushedIndex++]);
            }
            stack.pop();
        }
        return true;
    }
}
