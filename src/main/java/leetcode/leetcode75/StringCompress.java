package leetcode.leetcode75;

/**
 * @author tempo
 */
public class StringCompress {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int startIndexOfCurrentCharacter = 0;
        int writeIndexOfOutputArray = 1;
        for (int cursor = 1; cursor <= chars.length; cursor++) {
            if (cursor == chars.length) {
                if (cursor - startIndexOfCurrentCharacter > 1) {
                    char[] digits = String.valueOf(cursor - startIndexOfCurrentCharacter).toCharArray();
                    for (char digit : digits) {
                        chars[writeIndexOfOutputArray++] = digit;
                    }
                }
            } else {
                if (chars[cursor] != chars[startIndexOfCurrentCharacter]) {
                    int count = cursor - startIndexOfCurrentCharacter;
                    if (count > 1) {
                        char[] digits = String.valueOf(cursor - startIndexOfCurrentCharacter).toCharArray();
                        for (char digit : digits) {
                            chars[writeIndexOfOutputArray++] = digit;
                        }
                    }
                    chars[writeIndexOfOutputArray++] = chars[cursor];
                    startIndexOfCurrentCharacter = cursor;
                }
            }
        }
        return writeIndexOfOutputArray;
    }
}
