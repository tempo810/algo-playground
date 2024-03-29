package leetcode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class EvaluatePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                digits.push(calculate(digits.pop(), digits.pop(), token));
            } else {
                digits.push(Integer.valueOf(token));
            }
        }
        return digits.pop();
    }

    private int calculate(Integer b, Integer a, String token) {
        switch (token) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new Error();
        }
    }
}
