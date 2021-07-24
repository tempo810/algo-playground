package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Tempo
 */
public class WordLadderII {
    //TLE, queue indicate simple BFS can solve, no need trie
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordHash = new HashSet<>(wordList);
        Trie root = new Trie();
        for (String word : wordList) {
            char[] chars = word.toCharArray();
            Trie cursor = root;
            for (int i = 0; i < chars.length - 1; i++) {
                char c = chars[i];
                if (cursor.tries[c - 'a'] == null) {
                    cursor.tries[c - 'a'] = new Trie();
                }
                cursor = cursor.tries[c - 'a'];
            }
            cursor.tries[chars[chars.length - 1] - 'a'] = new Trie(word);
        }

        List<List<String>> results = new ArrayList<>();
        ArrayList<String> partialResult = new ArrayList<>();
        partialResult.add(beginWord);
        dfs(beginWord, endWord, wordHash, root, partialResult, results);
        return results;
    }

    private void dfs(String beginWord, String endWord, Set<String> wordHash, Trie trie, List<String> partialResult, List<List<String>> results) {
        if (beginWord.equals(endWord)) {
            if (results.isEmpty() || partialResult.size() == results.get(0).size()) {
                results.add(new ArrayList<>(partialResult));
            } else if (results.get(0).size() > partialResult.size()) {
                results.clear();
                results.add(new ArrayList<>(partialResult));
            }
            return;
        }

        if (results.isEmpty() || partialResult.size() <= results.get(0).size() - 1) {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '*';
                List<String> matches = find(trie, chars);
                for (String match : matches) {
                    if (wordHash.remove(match)) {
                        partialResult.add(match);
                        dfs(match, endWord, wordHash, trie, partialResult, results);
                        partialResult.remove(partialResult.size() - 1);
                        wordHash.add(match);
                    }
                }
                chars[i] = beginWord.charAt(i);
            }
        }
    }

    private List<String> find(Trie trie, char[] chars) {
        Queue<Trie> queue = new ArrayDeque<>();
        queue.add(trie);
        for (char aChar : chars) {
            if (aChar == '*') {
                for (int i = queue.size(); i > 0; i--) {
                    for (Trie t : queue.remove().tries) {
                        if (t != null) {
                            queue.add(t);
                        }
                    }
                }

            } else {
                for (int i = queue.size(); i > 0; i--) {
                    Trie pop = queue.remove();
                    Trie t = pop.tries[aChar - 'a'];
                    if (t != null) {
                        queue.add(t);
                    }
                }
            }
        }
        List<String> found = new ArrayList<>();
        while (!queue.isEmpty()) {
            found.add(queue.remove().word);
        }
        return found;
    }

    private static class Trie {
        public final String word;
        public final Trie[] tries = new Trie[26];

        private Trie(String word) {
            this.word = word;
        }

        private Trie() {
            this.word = null;
        }
    }
}
