package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class LetterCombinationOfPhoneNumber {
    private final Map<Character, List<Character>> numbers = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z'));

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder(digits.length());
            stringBuilder.setLength(digits.length());
            dfs(digits, 0, stringBuilder, ret);
        }
        return ret;
    }

    private void dfs(String digits, int index, StringBuilder stringBuilder, List<String> ret) {
        if (index >= digits.length()) {
            ret.add(stringBuilder.toString());
            return;
        }
        for (Character character : numbers.get(digits.charAt(index))) {
            stringBuilder.setCharAt(index, character);
            dfs(digits, index + 1, stringBuilder, ret);
        }
    }
}
