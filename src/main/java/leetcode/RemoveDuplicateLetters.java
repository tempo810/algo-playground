package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        boolean[] seen = new boolean[26];
        seen[chars[0] - 'a'] = true;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (!seen[c - 'a']) {
                while (!stack.isEmpty() && stack.peek() > c && i < lastIndex[stack.peek() - 'a']) {
                    seen[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                seen[c - 'a'] = true;
            }
        }
        int size = stack.size();
        StringBuilder sb = new StringBuilder();
        sb.setLength(size);
        while (size > 0) {
            sb.setCharAt(size - 1, stack.pop());
            size--;
        }
        return sb.toString();
    }
}
