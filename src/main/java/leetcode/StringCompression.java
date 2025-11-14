package leetcode;

/**
 * @author tempo
 */
public class StringCompression {
    public int compress(char[] chars) {
        return dfs(chars, 0);
    }

    private int dfs(char[] chars, int index) {
        if (index == chars.length) return 0;
        int cursor = index;
        while (cursor < chars.length && chars[index] == chars[cursor++]) {

        }
        int length = cursor - index;
        int compression = 1;
        if (length > 1) {
            while (length > 0) {
                length /= 10;
                compression++;
            }

        }
        return compression + dfs(chars, cursor);
    }
}
