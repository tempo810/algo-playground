package leetcode;

/**
 * @author tempo
 */
public class DecodeWays {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length() + 1];
        return decode(0, s, dp);
    }

    private int decode(int start, String s, Integer[] dp) {
        if (start == s.length()) {
            return 1;
        }

        if (s.charAt(start) == '0') {
            return 0;
        }

        Integer singleDigit = dp[start + 1];
        if (singleDigit == null) {
            singleDigit = decode(start + 1, s, dp);
            dp[start + 1] = singleDigit;
        }

        if (start < s.length() - 1 && Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            Integer doubleDigit = dp[start + 2];
            if (doubleDigit == null) {
                doubleDigit = decode(start + 2, s, dp);
                dp[start + 2] = doubleDigit;
            }
            return singleDigit + doubleDigit;
        }

        return singleDigit;
    }
}
