package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author tempo
 */
public class VowelSpellChecker {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Node root = new Node();
        Node cur = root;
        Map<String, String> firstAppearance = new HashMap<>();

        for (String word : wordlist) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (cur.children[c >= 97 ? c - 'a' : c - 39] == null) {
                    cur.children[c >= 97 ? c - 'a' : c - 39] = new Node();
                }
                if (VOWELS.contains(c)) {
                    cur.vowels.add(c >= 97 ? c - 'a' : c - 39);
                }
                cur = cur.children[c >= 97 ? c - 'a' : c - 39];
            }
            cur = root;
            firstAppearance.putIfAbsent(word.toLowerCase(), word);
        }

        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var sb = new StringBuilder();
            query(queries[i], root, sb);
            String result = sb.toString();
            results[i] = result.equals(queries[i]) ? result : firstAppearance.getOrDefault(result.toLowerCase(), result);
        }

        return results;
    }

    private void query(String query, Node root, StringBuilder sb) {
        if (sb.length() < query.length()) {
            char currentChar = query.charAt(sb.length());
            Node child = root.children[currentChar >= 97 ? currentChar - 'a' : currentChar - 39];

            if (child != null) {
                sb.append(currentChar);
                query(query, child, sb);
                if (sb.length() == query.length()) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
            }

            currentChar = Character.isLowerCase(currentChar) ? Character.toUpperCase(currentChar) : Character.toLowerCase(currentChar);
            child = root.children[currentChar >= 97 ? currentChar - 'a' : currentChar - 39];
            if (child != null) {
                sb.append(currentChar);
                query(query, child, sb);
                if (sb.length() == query.length()) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
            }

            if (VOWELS.contains(currentChar)) {
                for (Integer vowel : root.vowels) {
                    sb.append((char) (vowel <= 25 ? vowel + 'a' : vowel + 39));
                    query(query, root.children[vowel], sb);
                    if (sb.length() == query.length()) {
                        return;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    private static class Node {
        private final Node[] children = new Node[52];
        private final Queue<Integer> vowels = new ArrayDeque<>();
    }
}
