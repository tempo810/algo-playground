package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

/**
 * @author tempo
 */
public class VowelSpellChecker {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Node root = new Node();
        for (String word : wordlist) {
            char c = word.charAt(0);
            if (root.children[c >= 97 ? c - 'a' : c - 40] == null) {
                root.children[c >= 97 ? c - 'a' : c - 40] = new Node();
            }
            if (VOWELS.contains(c)) {
                root.vowels.add(c >= 97 ? c - 'a' : c - 40);
            }
            Node cur = root.children[c >= 97 ? c - 'a' : c - 40];

            for (int j = 1; j < word.length(); j++) {
                c = word.charAt(j);
                if (cur.children[c >= 97 ? c - 'a' : c - 40] == null) {
                    cur.children[c >= 97 ? c - 'a' : c - 40] = new Node();
                }
                if (VOWELS.contains(c)) {
                    cur.vowels.add(c >= 97 ? c - 'a' : c - 40);
                }
                cur = cur.children[c >= 97 ? c - 'a' : c - 40];
            }
        }

        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var sb = new StringBuilder();
            query(queries[i], root, sb);
            results[i] = sb.toString();
        }

        return results;
    }

    private void query(String query, Node root, StringBuilder sb) {
        if (sb.length() < query.length()) {
            char currentChar = query.charAt(sb.length());
            Node child = root.children[currentChar >= 97 ? currentChar - 'a' : currentChar - 40];

            if (child != null) {
                sb.append(currentChar);
                query(query, child, sb);
                if (sb.length() == query.length()) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
            }

            currentChar = Character.isLowerCase(currentChar) ? Character.toUpperCase(currentChar) : Character.toLowerCase(currentChar);
            child = root.children[currentChar >= 97 ? currentChar - 'a' : currentChar - 40];
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
                    sb.append((char) (vowel <= 25 ? vowel + 'a' : vowel + 40));
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
