package leetcode;

/**
 * @author Tempo
 */
public class WordSearch {
    private final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (found(board, chars, i, j, 0, visited)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean found(char[][] board, char[] chars, int row, int col, int index, boolean[][] visited) {
        if (index == chars.length) {
            return true;
        }

        if (row < 0 || row == visited.length || col < 0 || col == visited[0].length || visited[row][col] || board[row][col] != chars[index]) {
            return false;
        }

        visited[row][col] = true;
        for (int[] direction : directions) {
            if (found(board, chars, row + direction[0], col + direction[1], index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
