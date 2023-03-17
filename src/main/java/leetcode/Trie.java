package leetcode;

/**
 * @author tempo
 */
class Trie {
    private final Trie[] trie;

    private boolean isCompleted = false;

    public Trie() {
        trie = new Trie[26];
    }

    public void insert(String word) {
        Trie cursor = this;
        for (char c : word.toCharArray()) {
            if (cursor.trie[c - 'a'] == null) {
                cursor.trie[c - 'a'] = new Trie();
            }
            cursor = cursor.trie[c - 'a'];
        }
        cursor.isCompleted = true;
    }


    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.trie[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isCompleted;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.trie[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
