package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        TrieNode root = new TrieNode();
        int totalLength = 0;
        for (int i = 0; i < words.length; i++) {
            TrieNode current = root;
            char[] word = words[i].toCharArray();
            for (char c : word) {
                current = current.createChildren(c);
                totalLength++;
            }
            current.index = i;
            current.expected++;
        }
        char[] chars = s.toCharArray();
        Map<Integer, Integer> counters = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int expectedWord = words.length;
        for (int i = 0; i <= chars.length - totalLength; i++) {
            boolean matched = isMatch(chars, root, i, totalLength, counters, expectedWord);
            if (matched) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isMatch(char[] chars, TrieNode root, int start, int length, Map<Integer, Integer> counters, int expectedWords) {
        counters.clear();
        TrieNode cursor = root;
        int foundWords = 0;
        for (int i = start; i < start + length; i++) {
            cursor = cursor.getChildren(chars[i]);
            if (cursor == null) {
                return false;
            }
            if (cursor.index != null) {
                Integer count = counters.compute(cursor.index, (k, v) -> v == null ? 1 : v + 1);
                if (count > cursor.expected) {
                    return false;
                }
                foundWords++;
                cursor = root;
            }
        }
        return foundWords == expectedWords;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        Integer index = null;
        int expected = 0;

        public TrieNode createChildren(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            return children[c - 'a'];
        }

        public TrieNode getChildren(char c) {
            return children[c - 'a'];
        }
    }
}
