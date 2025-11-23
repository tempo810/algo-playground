package leetcode.leetcode75;

/**
 * @author tempo
 */
public class GreatestCommonDivisorOfStrings {
    private static boolean canDivide(String str1, char[] subString) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != subString[i % subString.length]) {
                return false;
            }
        }
        return true;
    }

    public String gcdOfStrings(String str1, String str2) {
        for (int divider = Math.min(str1.length(), str2.length()); divider > 0; divider--) {
            if (str1.length() % divider == 0 && str2.length() % divider == 0) {
                char[] subString = new char[divider];
                str1.getChars(0, divider, subString, 0);
                if (canDivide(str1, subString) && canDivide(str2, subString)) {
                    return new String(subString);
                }
            }
        }
        return "";
    }
}
