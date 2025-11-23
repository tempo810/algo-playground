package leetcode.leetcode75;

import java.util.Stack;

/**
 * @author tempo
 */
public class DecodeString {

    private int currentIndex = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multiplier = 0;
        while (this.currentIndex < s.length()) {
            final char currentChar = s.charAt(currentIndex++);
            if (currentChar >= 'a' && currentChar <= 'z') {
                sb.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                if (multiplier > 0) {
                    multiplier *= 10;
                }
                multiplier += currentChar - '0';
            } else if (currentChar == '[') {
                final String s1 = decodeString(s);
                for (int i = 0; i < multiplier; i++) {
                    sb.append(s1);
                }
            } else if (currentChar == ']') {
                break;
            }
        }
        return sb.toString();
    }

    public String decodeStringBfs(String s) {
        Stack<Integer> multipliers = new Stack<>();
        Stack<StringBuilder> segments = new Stack<>();
        StringBuilder currentSegment = new StringBuilder();
        int multiplier = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                currentSegment.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                multiplier = multiplier * 10 + currentChar - '0';
            } else if (currentChar == '[') {
                multipliers.push(multiplier);
                multiplier = 0;
                segments.push(currentSegment);
                currentSegment = new StringBuilder();
            } else {
                final Integer currentMultiplier = multipliers.pop();
                final StringBuilder lastSegment = segments.pop();
                for (int j = 0; j < currentMultiplier; j++) {
                    lastSegment.append(currentSegment);
                }
                currentSegment = lastSegment;
            }
        }
        return currentSegment.toString();
    }
}
