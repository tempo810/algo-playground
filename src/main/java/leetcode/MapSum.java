package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class MapSum {

    /**
     * Initialize your data structure here.
     */
    private final CountingTrie root;
    private final Map<String, Integer> valueHash;

    public MapSum() {
        root = new CountingTrie();
        valueHash = new HashMap<>();
    }

    public void insert(String key, int val) {
        Integer oldValue = valueHash.put(key, val);
        int currentValue = oldValue != null ? val - oldValue : val;
        CountingTrie node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node.trie[key.charAt(i) - 'a'] == null) {
                node.trie[key.charAt(i) - 'a'] = new CountingTrie();
            }
            node.trie[key.charAt(i) - 'a'].val += currentValue;
            node = node.trie[key.charAt(i) - 'a'];
        }
    }

    public int sum(String prefix) {
        CountingTrie node = root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.trie[prefix.charAt(i) - 'a'];
            if (node == null) {
                return 0;
            }
        }
        return node.val;
    }

    public static class CountingTrie {
        private final CountingTrie[] trie = new CountingTrie[26];
        private int val = 0;
    }
}
