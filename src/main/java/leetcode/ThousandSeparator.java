package leetcode;

/**
 * @author Tempo
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = String.valueOf(n).toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (count == 3) {
                sb.insert(0, '.');
                count = 0;
            }
            sb.insert(0, chars[i]);
            count++;
        }
        return sb.toString();
    }
}
