package leetcode.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        this.generateParenthesis(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private void generateParenthesis(StringBuilder stringBuilder, int opened, int close, int target, List<String> result) {
        if (close == target) {
            result.add(stringBuilder.toString());
        }
        if (opened < target) {
            stringBuilder.append('(');
            generateParenthesis(stringBuilder, opened + 1, close, target, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (close < opened) {
            stringBuilder.append(')');
            generateParenthesis(stringBuilder, opened, close + 1, target, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
