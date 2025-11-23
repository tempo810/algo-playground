package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tempo
 */
public class SearchSuggestionSystem {

    private final TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            insert(product);
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode node = this.root;
        for (int i = 0; i < searchWord.length(); i++) {
            if (node == null || node.children[searchWord.charAt(i) - 'a'] == null) {
                node = null;
                result.add(List.of());
            } else {
                node = node.children[searchWord.charAt(i) - 'a'];
                result.add(node.storedProducts.stream().limit(3).toList());
            }
        }
        return result;
    }

    private void insert(String product) {
        TrieNode node = this.root;
        for (int i = 0; i < product.length(); i++) {
            char c = product.charAt(i);
            TrieNode child = node.children[c - 'a'];
            if (child == null) {
                child = new TrieNode();
                node.children[c - 'a'] = child;
            }
            child.storedProducts.add(product);
            node = child;
        }
    }

    private static final class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private final List<String> storedProducts = new ArrayList<>();
    }
}
