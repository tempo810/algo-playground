package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int remaining = k;
        Stack<Character> characters = new Stack<>();

        for (char number : num.toCharArray()) {
            while (remaining > 0 && !characters.isEmpty() && characters.peek() > number) {
                characters.pop();
                remaining--;
            }
            characters.push(number);
        }


        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            if (remaining > 0) {
                remaining--;
            } else if (character != '0' || !sb.isEmpty()) {
                sb.append(character);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
