package leetcode.datastructure;

/**
 * @author Tempo
 */
public class TrieNode {
    public TrieNode[] children;
    public int count;
    public boolean stop = false;

    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
