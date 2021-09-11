package leetcode;

/**
 * @author Tempo
 */
public class BasicCalculator {
    public int calculate(String equation) {
        return calculate(equation.toCharArray(), 0)[0];
    }

    public int[] calculate(char[] equation, int index) {
        int total = 0;
        int sign = 1;
        int token = 0;
        int localIndex = index;
        while (localIndex < equation.length && equation[localIndex] != ')') {
            char currentChar = equation[localIndex];
            if (currentChar != ' ') {
                if (Character.isDigit(currentChar)) {
                    token = token * 10 + Character.getNumericValue(currentChar);
                } else if (currentChar == '+' || currentChar == '-') {
                    total += sign * token;
                    token = 0;
                    sign = currentChar == '+' ? 1 : -1;
                } else if (currentChar == '(') {
                    int[] result = calculate(equation, localIndex + 1);
                    token = result[0];
                    localIndex = result[1];
                }
            }
            localIndex++;
        }
        return new int[]{total + sign * token, localIndex};
    }
}
