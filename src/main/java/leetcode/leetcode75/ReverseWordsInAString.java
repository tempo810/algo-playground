package leetcode.leetcode75;

/**
 * @author tempo
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                index--;
            } else {
                int cursor = index - 1;
                while (cursor >= 0 && s.charAt(cursor) != ' ') {
                    cursor--;
                }
                if (!sb.isEmpty()) {
                    sb.append(' ');
                }
                sb.append(s, cursor + 1, index + 1);
                index = cursor - 1;
            }
        }
        return sb.toString();
    }
}
