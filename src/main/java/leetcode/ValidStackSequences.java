package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class ValidStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushedHighWaterMark = 0;
        int poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (poppedIndex < popped.length) {
            if (pushedHighWaterMark < pushed.length && pushed[pushedHighWaterMark] == popped[poppedIndex]) {
                pushedHighWaterMark++;
                poppedIndex++;
            } else if (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            } else {
                if (pushedHighWaterMark == pushed.length) {
                    return false;
                }
                stack.push(pushed[pushedHighWaterMark]);
                pushedHighWaterMark++;
            }
        }
        return true;
    }
}
