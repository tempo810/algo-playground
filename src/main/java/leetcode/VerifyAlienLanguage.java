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

    public boolean isAlienSorted2(String[] words, String order) {
        int[] hash = new int[26];
        int index = 0;
        for (char c : order.toCharArray()) {
            hash[c - 'a'] = index++;
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSorted(words[i - 1], words[i], hash)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String firstWord, String secondWord, int[] hash) {
        final char[] firstWordChars = firstWord.toCharArray();
        final char[] secondWordChars = secondWord.toCharArray();
        final int minLength = Math.min(firstWordChars.length, secondWordChars.length);
        for (int i = 0; i < minLength; i++) {
            if (hash[secondWordChars[i] - 'a'] > hash[firstWordChars[i] - 'a']) {
                return true;
            }
            if (hash[secondWordChars[i] - 'a'] < hash[firstWordChars[i] - 'a']) {
                return false;
            }
        }
        return secondWordChars.length >= firstWordChars.length;
    }
}
