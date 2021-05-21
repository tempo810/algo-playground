package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        var sb = new StringBuilder(n * 2);
        sb.setLength(n * 2);
        dfs(n, n, result, sb);
        return result;
    }

    private void dfs(int open, int close, List<String> result, StringBuilder sb) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        if (open > 0) {
            sb.setCharAt(sb.length() - open - close, '(');
            dfs(open - 1, close, result, sb);
        }

        if (close > open) {
            sb.setCharAt(sb.length() - open - close, ')');
            dfs(open, close - 1, result, sb);
        }
    }
}
