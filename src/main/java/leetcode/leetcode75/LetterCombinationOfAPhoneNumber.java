package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class LetterCombinationOfAPhoneNumber {
    List<String> result = new ArrayList<>();
    Map<Integer, List<Character>> characters = Map.of(
            2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'),
            4, List.of('g', 'h', 'i'),
            5, List.of('j', 'k', 'l'),
            6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'),
            8, List.of('t', 'u', 'v'),
            9, List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        add(0, digits, sb);
        return result;
    }

    private void add(int i, String digits, StringBuilder sb) {
        if (i == digits.length()) {
            result.add(sb.toString());
        } else {
            for (Character c : characters.get((digits.charAt(i)) - '0')) {
                sb.append(c);
                add(i + 1, digits, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
