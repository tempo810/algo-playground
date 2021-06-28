package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class RemoveDuplicateFromString {
    public String removeDuplicates(String s) {
        Stack<Character> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!characters.isEmpty() && characters.peek() == c) {
                while (!characters.isEmpty() && characters.peek() == c) {
                    characters.pop();
                }
            } else {
                characters.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.toString();
    }
}
