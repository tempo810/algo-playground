package leetcode;

/**
 * @author Tempo
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        boolean carry = false;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < num1.length() || index < num2.length()) {
            int num1Digit = num1.length() - 1 - index >= 0 ? num1.charAt(num1.length() - 1 - index) - '0' : 0;
            int num2Digit = num2.length() - 1 - index >= 0 ? num2.charAt(num2.length() - 1 - index) - '0' : 0;
            int result = num1Digit + num2Digit;
            result += carry ? 1 : 0;
            sb.append(result % 10);
            carry = result >= 10;
            index++;
        }

        if (carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
