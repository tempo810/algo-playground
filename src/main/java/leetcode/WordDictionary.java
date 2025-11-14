package leetcode;

import leetcode.datastructure.TrieNode;

/**
 * @author tempo
 */
public class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.get(c);
        }
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int index, TrieNode root) {
        if (index == chars.length) {
            return true;
        }

        if (root == null) {
            return false;
        }
        char current = chars[index];
        if (current == '.') {
            if (index == chars.length - 1) {
                return true;
            }
            for (TrieNode child : root.children) {
                if (search(chars, index + 1, child)) {
                    return true;
                }
            }
        } else if (root.children[current - 'a'] != null) {
            TrieNode child = root.children[current - 'a'];
            return search(chars, index + 1, child);
        }
        return false;
    }
}
