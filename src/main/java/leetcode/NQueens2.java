package leetcode;

/**
 * @author Tempo
 */
public class NQueens2 {

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return dfs(board, 0);
    }

    private int dfs(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < board[row].length; i++) {
            if (validMove(board, row, i)) {
                board[row][i] = true;
                total += dfs(board, row + 1);
                board[row][i] = false;
            }
        }
        return total;
    }

    private boolean validMove(boolean[][] board, int row, int col) {
        for (boolean[] currentRow : board) {
            if (currentRow[col]) {
                return false;
            }
        }
        for (int k = 1; k <= row; k++) {
            if (col - k >= 0 && board[row - k][col - k]) {
                return false;
            }
            if (col + k < board[row - k].length && board[row - k][col + k]) {
                return false;
            }
        }
        for (int k = 1; k < board.length - row; k++) {
            if (col - k >= 0 && board[row + k][col - k]) {
                return false;
            }
            if (col + k < board[row + k].length && board[row + k][col + k]) {
                return false;
            }
        }
        return true;
    }
}
