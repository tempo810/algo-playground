package leetcode;

import leetcode.datastructure.TrieNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Tempo
 */
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> answer = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String substring = word.substring(word.length() - i);
                answer.remove(substring);
            }
        }

        int count = 0;
        for (String s : answer) {
            count += s.length() + 1;
        }
        return count;
    }

    // explanation: if s1 a substring of s2, the head node of s1 in nodes map will has children node of s2 (and count > 0).
    public int minimumLengthEncodingTrieDemo(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }
}
