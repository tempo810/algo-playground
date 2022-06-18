package leetcode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Tempo
 */
public class WordFilter {
    final TrieNode rootTrie;

    public WordFilter(String[] words) {
        rootTrie = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            add(words[i], i, rootTrie);
        }
    }

    private void add(String word, int index, TrieNode rootTrie) {
        Queue<TrieNode> tries = new ArrayDeque<>();
        tries.add(rootTrie);
        TrieNode cursor = rootTrie;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (cursor.tries[c - 'a'] == null) {
                cursor.tries[c - 'a'] = new TrieNode(c, cursor);
            }
            cursor = cursor.tries[c - 'a'];
            tries.add(cursor);
        }

        while (!tries.isEmpty()) {
            tries.poll().suffices.put(index, cursor);
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cursor = rootTrie;
        for (char c : prefix.toCharArray()) {
            cursor = cursor.tries[c - 'a'];
            if (cursor == null) {
                return -1;
            }
        }

        Map<Integer, TrieNode> suffices = cursor.suffices;
        char[] suffixChars = suffix.toCharArray();
        for (Map.Entry<Integer, TrieNode> entry : suffices.entrySet()) {
            cursor = entry.getValue();
            int i = suffixChars.length - 1;
            while (i >= 0 && cursor.currentKey != null && cursor.currentKey == suffixChars[i]) {
                i--;
                cursor = cursor.rootNode;
            }
            if (i == -1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static class TrieNode {
        final Character currentKey;
        final TrieNode[] tries = new TrieNode[26];
        final Map<Integer, TrieNode> suffices = new TreeMap<>(Comparator.reverseOrder());
        private final TrieNode rootNode;

        private TrieNode(Character currentKey, TrieNode rootNode) {
            this.currentKey = currentKey;
            this.rootNode = rootNode;
        }

        private TrieNode() {
            this.currentKey = null;
            this.rootNode = null;
        }
    }
}
