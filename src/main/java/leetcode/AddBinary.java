package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        final char[] aChars = a.toCharArray();
        final char[] bChars = b.toCharArray();

        final int minLength = Math.min(aChars.length, bChars.length);
        char[] chars = new char[Math.max(aChars.length, bChars.length) + 1];
        Arrays.fill(chars, '0');

        int i = 0;
        for (; i < minLength; i++) {
            final char aChar = aChars[aChars.length - i - 1];
            final char bChar = bChars[bChars.length - i - 1];
            final char currentChar = chars[chars.length - i - 1];
            if (aChar != bChar) {
                if (currentChar == '1') {
                    chars[chars.length - 1 - i] = '0';
                    chars[chars.length - 2 - i] = '1';
                } else {
                    chars[chars.length - 1 - i] = '1';
                }
            } else if (aChar == '1') {
                chars[chars.length - 2 - i] = '1';
            }
        }

        char[] remainingChars = aChars.length > bChars.length ? aChars : bChars;
        for (; i < remainingChars.length; i++) {
            if (remainingChars[remainingChars.length - i - 1] == '1') {
                if (chars[chars.length - i - 1] == '1') {
                    chars[chars.length - i - 1] = '0';
                    chars[chars.length - i - 2] = '1';
                } else {
                    chars[chars.length - i - 1] = '1';
                }
            }
        }

        return chars[0] == '0' ? new String(chars, 1, chars.length - 1) : new String(chars);
    }
}
