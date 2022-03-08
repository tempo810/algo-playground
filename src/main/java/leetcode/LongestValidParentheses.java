package leetcode;

/**
 * @author Tempo
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                maxLength = Math.max(maxLength, open * 2);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                close++;
            } else {
                open++;
            }
            if (open == close) {
                maxLength = Math.max(maxLength, open * 2);
            } else if (open > close) {
                open = 0;
                close = 0;
            }
        }
        return maxLength;
    }
}
