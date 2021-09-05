package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String result = s;
        for (int i = 1; i < s.length(); i++) {
            String rotatedString = s.substring(i) + s.substring(0, i);
            if (rotatedString.compareTo(result) < 0) {
                result = rotatedString;
            }
        }
        return result;
    }
}
