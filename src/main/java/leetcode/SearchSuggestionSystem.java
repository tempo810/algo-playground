package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode current = root;
            for (char c : product.toCharArray()) {
                if (current.nodes[c - 'a'] == null) current.nodes[c - 'a'] = new TrieNode();
                current.nodes[c - 'a'].addSuggestion(product);
                current = current.nodes[c - 'a'];
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            TrieNode node = root.nodes[c - 'a'];
            if (node == null) {
                break;
            }
            List<String> currentResult = new ArrayList<>();
            for (String suggestion : node.suggestions) {
                if (suggestion != null) {
                    currentResult.add(suggestion);
                }
            }
            result.add(currentResult);
            root = node;
        }
        while (result.size() < searchWord.length()) {
            result.add(List.of());
        }
        return result;
    }

    private static class TrieNode {
        private final TrieNode[] nodes = new TrieNode[26];
        String[] suggestions = new String[3];

        private void addSuggestion(String word) {
            int insertionPoint = 0;
            while (insertionPoint < suggestions.length) {
                if (suggestions[insertionPoint] == null) {
                    break;
                } else if (suggestions[insertionPoint].compareTo(word) > 0) {
                    if (insertionPoint < 2) {
                        System.arraycopy(suggestions, insertionPoint, suggestions, insertionPoint + 1, suggestions.length - 1 - insertionPoint);
                    }
                    break;
                } else {
                    insertionPoint++;
                }
            }
            if (insertionPoint < suggestions.length) {
                suggestions[insertionPoint] = word;
            }
        }
    }
}
