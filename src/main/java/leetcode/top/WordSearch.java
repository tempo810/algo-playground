package leetcode.top;

/**
 * @author tempo
 */
public class WordSearch {
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int n, int m, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (n < 0 || m < 0 || n == board.length || m == board[0].length || visited[n][m] || board[n][m] != word.charAt(index)) {
            return false;
        }
        visited[n][m] = true;
        for (int[] direction : directions) {
            if (dfs(board, word, index + 1, n + direction[0], m + direction[1], visited)) {
                return true;
            }
        }
        visited[n][m] = false;
        return false;
    }
}
