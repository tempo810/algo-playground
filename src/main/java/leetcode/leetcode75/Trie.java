package leetcode.leetcode75;

/**
 * @author tempo
 */
public class Trie {
    private final Trie[] trie;
    private boolean isEndOfWord;

    public Trie() {
        this.trie = new Trie[26];
        this.isEndOfWord = false;
    }

    public void insert(String word) {
        Trie currentTrie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie nextTrie = currentTrie.trie[c - 'a'];
            if (nextTrie == null) {
                nextTrie = new Trie();
                currentTrie.trie[c - 'a'] = nextTrie;
            }
            currentTrie = nextTrie;
        }
        currentTrie.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie currentTrie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            currentTrie = currentTrie.trie[c - 'a'];
            if (currentTrie == null) {
                return false;
            }
        }
        return currentTrie.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie currentTrie = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            currentTrie = currentTrie.trie[c - 'a'];
            if (currentTrie == null) {
                return false;
            }
        }
        return true;
    }
}
