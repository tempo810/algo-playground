package leetcode;

/**
 * @author Tempo
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];

        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            hash[c - 'a']--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == -1) return (char) (i + 'a');
        }

        return (char) -1;
    }
}
