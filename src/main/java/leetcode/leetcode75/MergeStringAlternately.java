package leetcode.leetcode75;

/**
 * @author tempo
 */
public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        int diff = word1.length() - word2.length();
        if (diff > 0) {
            sb.append(word1, word1.length() - diff, word1.length());
        } else if (diff < 0) {
            diff *= -1;
            sb.append(word2, word2.length() - diff, word2.length());
        }
        return sb.toString();
    }
}
