package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class LongestPalindromeByConcat2Letters {
    public int longestPalindrome(String[] words) {
        boolean foundMid = false;
        int totalLength = 0;
        Map<String, Integer> found = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                if (!foundMid) {
                    totalLength += 2;
                    foundMid = true;
                }
            } else {
                final String targetString = sb.append(word).reverse().toString();
                Integer occurrence = found.computeIfPresent(targetString, (k, v) -> v - 1);
                if (occurrence != null && occurrence >= 0) {
                    totalLength += 4;
                } else {
                    found.compute(word, (k, v) -> {
                        if (v == null || v < 0) {
                            v = 1;
                        } else {
                            v += 1;
                        }
                        return v;
                    });
                }
            }
            sb.setLength(0);
        }

        return totalLength;
    }
}
