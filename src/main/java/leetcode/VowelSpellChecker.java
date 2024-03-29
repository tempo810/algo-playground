package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author tempo
 */
public class VowelSpellChecker {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie root = new Trie();
        Trie current = root;
        for (String word : wordlist) {
            for (int i = 0; i < word.length(); i++) {
                int index = getIndex(word, i);
                if (current.children[index] == null) {
                    current.children[index] = new Trie();
                }
                current = current.children[index];
            }
            current.matchList.add(word);
            current = root;
        }

        String[] results = new String[queries.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = query(root, queries[i]);
        }

        return results;
    }

    private String query(Trie root, String query) {
        Trie current = root;
        for (int i = 0; i < query.length(); i++) {
            int index = getIndex(query, i);
            current = current.children[index];
            if (current == null) {
                return "";
            }
        }

        if (!current.matchList.isEmpty()) {
            String wildCardMatch = null;
            for (String s : current.matchList) {
                if (query.equals(s)) {
                    return s;
                } else if (wildCardMatch == null && query.equalsIgnoreCase(s)) {
                    wildCardMatch = s;
                }
            }
            return wildCardMatch != null ? wildCardMatch : current.matchList.get(0);
        }
        return "";
    }

    private int getIndex(String query, int i) {
        char c = Character.toLowerCase(query.charAt(i));
        return VOWELS.contains(c) ? 0 : c - 'a';
    }

    private static class Trie {
        private final Trie[] children = new Trie[26];
        private final List<String> matchList = new ArrayList<>();
    }
}
