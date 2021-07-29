package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> wordMap = new HashMap<>();
        for (String word : wordDict) {
            wordMap.computeIfAbsent(word.charAt(0), key -> new ArrayList<>()).add(word);
        }

        List<String> results = new ArrayList<>();
        dfs(s.toCharArray(), 0, new ArrayList<>(), results, wordMap);
        return results;
    }

    private void dfs(char[] s, int startIndex, List<String> partial, List<String> results, Map<Character, List<String>> wordMap) {
        if (startIndex == s.length) {
            results.add(String.join(" ", partial));
        } else if (startIndex < s.length) {
            List<String> words = wordMap.get(s[startIndex]);
            if (words != null) {
                for (String word : words) {
                    if (match(s, startIndex, word)) {
                        partial.add(word);
                        dfs(s, startIndex + word.length(), partial, results, wordMap);
                        partial.remove(partial.size() - 1);
                    }
                }
            }
        }
    }

    private boolean match(char[] s, int startIndex, String word) {
        if (s.length - startIndex < word.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (s[startIndex + i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
