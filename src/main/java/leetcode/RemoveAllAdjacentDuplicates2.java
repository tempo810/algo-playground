package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class RemoveAllAdjacentDuplicates2 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        int index = 0;
        int consecutiveCount = 1;
        while (index < chars.size() - 1) {
            if (chars.get(index).equals(chars.get(index + 1))) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
            if (consecutiveCount == k) {
                for (int i = 0; i < k; i++) {
                    chars.remove(index + 1 - i);
                }
                index = Math.max(index - (2 * k - 1), -1);
                consecutiveCount = 1;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
