package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class WordSearch2 {
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String... words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.add(c);
            }
            current.total++;
            current.word = word;
        }

        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, root, row, col, visited, result);
                if (result.size() == words.length) {
                    return result;
                }
            }
        }
        return result;
    }

    private int dfs(char[][] board, TrieNode root, int row, int col, boolean[][] visited, List<String> result) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
                || visited[row][col] || root.total == root.found) {
            return 0;
        }
        TrieNode node = root.nodes[board[row][col] - 'a'];
        if (node == null) {
            return 0;
        }

        visited[row][col] = true;
        int prevFound = node.found;
        if (node.word != null) {
            result.add(node.word);
            node.found++;
            node.word = null;
        }

        for (int i = 0; i < directions.length && node.found < node.total; i++) {
            node.found += dfs(board, node, row + directions[i][0], col + directions[i][1], visited, result);
        }
        visited[row][col] = false;
        return node.found - prevFound;
    }


    private static class TrieNode {
        final TrieNode[] nodes = new TrieNode[26];
        int total = 0;
        int found = 0;
        String word = null;

        TrieNode add(char character) {
            total++;
            if (nodes[character - 'a'] == null) {
                nodes[character - 'a'] = new TrieNode();
            }
            return nodes[character - 'a'];
        }
    }
}
