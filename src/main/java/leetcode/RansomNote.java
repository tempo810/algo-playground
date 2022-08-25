package leetcode;

/**
 * @author tempo
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineChars = new int[26];
        for (char c : magazine.toCharArray()) {
            magazineChars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--magazineChars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
