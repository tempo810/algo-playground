package leetcode;

/**
 * @author Tempo
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int s1Index, String s2, int s2Index, String s3, int s3Index) {
        if (s3Index == s3.length()) {
            return true;
        }
        if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s3Index) && dfs(s1, s1Index + 1, s2, s2Index, s3, s3Index + 1)) {
            return true;
        }
        return s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s3Index) && dfs(s1, s1Index, s2, s2Index + 1, s3, s3Index + 1);
    }
}
