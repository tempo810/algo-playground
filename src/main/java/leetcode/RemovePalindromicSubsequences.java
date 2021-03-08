package leetcode;

/**
 * @author Tempo
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int low = 0;
        while (low < s.length() / 2) {
            if (s.charAt(low) != s.charAt(s.length() - 1 - low)) {
                return 2;
            }
            low++;

        }
        return 1;
    }
}
