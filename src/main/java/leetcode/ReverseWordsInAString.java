package leetcode;

/**
 * @author tempo
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        var sb = new StringBuilder();
        while (end < s.length()) {
            if (s.charAt(end) == ' ') {
                if (end - start > 0) {
                    if (sb.length() > 0) {
                        sb.insert(0, " ");
                    }
                    sb.insert(0, s.substring(start, end));
                }
                start = end + 1;
            }
            end++;
        }

        if (s.charAt(s.length() - 1) != ' ') {
            if (sb.length() > 0) {
                sb.insert(0, " ");
            }
            sb.insert(0, s.substring(start, end));
        }

        return sb.toString();
    }
}
