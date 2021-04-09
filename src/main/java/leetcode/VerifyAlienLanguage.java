package leetcode;

/**
 * @author Tempo
 */
public class VerifyAlienLanguage {
    public boolean isAlienSorted(String[] words, String order) {
        char[] orderedChars = order.toCharArray();
        int[] dict = new int[26];

        for (int i = 0; i < orderedChars.length; i++) {
            dict[orderedChars[i] - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            boolean sorted = false;
            for (int j = 0; j < Math.min(words[i].length(), words[i - 1].length()) && !sorted; j++) {
                if (dict[words[i].charAt(j) - 'a'] > dict[words[i - 1].charAt(j) - 'a']) {
                    sorted = true;
                }
                if (dict[words[i].charAt(j) - 'a'] < dict[words[i - 1].charAt(j) - 'a']) {
                    return false;
                }
            }
            if (!sorted && words[i].length() < words[i - 1].length()) {
                return false;
            }
        }
        return true;
    }
}
