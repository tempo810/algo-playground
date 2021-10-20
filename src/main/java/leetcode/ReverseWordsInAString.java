package leetcode;

/**
 * @author Tempo
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int endIndex = chars.length - 1;

        while (endIndex >= 0) {
            if (chars[endIndex] != ' ') {
                int startIndex = findStartIndex(chars, endIndex);
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(chars, startIndex, endIndex - startIndex + 1);
                endIndex = startIndex;
            }
            endIndex--;
        }
        return sb.toString();
    }

    private int findStartIndex(char[] chars, int endIndex) {
        int startIndex = endIndex;
        while (startIndex >= 0 && chars[startIndex] != ' ') {
            startIndex--;
        }
        return startIndex + 1;
    }

    public String reverseWordsOld(String s) {
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
