package leetcode;

import java.util.Map;
import java.util.Stack;

/**
 * @author Tempo
 */
public class ValidParentheses {
    private final Map<Character, Character> lookUp = Map.of(')', '(', '}', '{', ']', '[');

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            Character opening = lookUp.get(aChar);
            if (opening != null) {
                if (stack.isEmpty() || !opening.equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
}
