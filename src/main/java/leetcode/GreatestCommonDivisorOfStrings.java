package leetcode;

/**
 * @author tempo
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str2.substring(0, gcd(str1.length(), str2.length()));
        }
        return "";
    }

    private int gcd(int length, int length1) {
        if (length1 == 0) {
            return length;
        }
        return gcd(length1, length % length1);
    }
}
