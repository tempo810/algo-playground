package leetcode;

import leetcode.datastructure.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
        List<TrieNode> heads = new ArrayList<>();
        Set<String> exists = new HashSet<>();

        for (String word : words) {
            if (!exists.add(word)) {
                heads.add(null);
                continue;
            }
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            heads.add(cur);
        }

        int ans = 0;
        for (int i = 0; i < heads.size(); i++) {
            TrieNode node = heads.get(i);
            if (node != null && node.count == 0) {
                ans += words[i].length() + 1;

            }
        }
        return ans;
    }
}
