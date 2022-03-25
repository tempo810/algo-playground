package leetcode;

/**
 * @author Tempo
 */
public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int remainingValue = k;
        for (int i = n; i > 0; i--) {
            if ((i - 1) * 26 + 1 >= remainingValue) {
                sb.append('a');
                remainingValue--;
            } else {
                int shift = remainingValue % 26;
                if (shift == 0) {
                    sb.append("z".repeat(Math.max(0, remainingValue / 26)));
                    break;
                } else {
                    char character = (char) ('a' + shift - 1);
                    sb.append(character);
                    remainingValue -= ((character - 'a') + 1);
                }
            }
        }
        return sb.toString();
    }
}
