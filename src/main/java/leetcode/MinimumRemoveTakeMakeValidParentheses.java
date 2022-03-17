package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class MinimumRemoveTakeMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        boolean[] remove = new boolean[s.length()];
        Stack<Integer> openBlankets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                openBlankets.push(i);
            } else if (chars[i] == ')') {
                if (!openBlankets.isEmpty()) {
                    openBlankets.pop();
                } else {
                    remove[i] = true;
                }
            }
        }

        while (!openBlankets.isEmpty()) {
            remove[openBlankets.pop()] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < remove.length; i++) {
            if (!remove[i]) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
