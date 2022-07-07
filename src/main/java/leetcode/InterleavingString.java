package leetcode;

/**
 * @author Tempo
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() == s3.length()) {
            Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
            return dfs(dp, s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray());
        }
        return false;
    }

    private boolean dfs(Boolean[][] dp, char[] a, int aIndex, char[] b, int bIndex, char[] target) {
        if (aIndex + bIndex == target.length) {
            return true;
        }
        if (dp[aIndex][bIndex] == null) {
            dp[aIndex][bIndex] = false;
            if (aIndex < a.length && a[aIndex] == target[aIndex + bIndex]) {
                dp[aIndex][bIndex] = dfs(dp, a, aIndex + 1, b, bIndex, target);
            }
            if (!dp[aIndex][bIndex] && bIndex < b.length && b[bIndex] == target[aIndex + bIndex]) {
                dp[aIndex][bIndex] = dfs(dp, a, aIndex, b, bIndex + 1, target);
            }
        }
        return dp[aIndex][bIndex];
    }
}
