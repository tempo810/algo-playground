package leetcode;

/**
 * @author Tempo
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] num1Digits = num1.toCharArray();
        char[] num2Digits = num2.toCharArray();
        int[] value = new int[num1Digits.length + num2Digits.length];
        for (int i = num1Digits.length - 1; i >= 0; i--) {
            for (int j = num2Digits.length - 1; j >= 0; j--) {
                int product = (num1Digits[i] - '0') * (num2Digits[j] - '0');
                product += value[i + j + 1];
                value[i + j + 1] = product % 10;
                value[i + j] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j : value) {
            if (sb.length() > 0 || j != 0) {
                sb.append(j);
            }
        }
        return sb.toString();
    }
}
