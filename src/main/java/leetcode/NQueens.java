package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> results = new ArrayList<>();
        dfs(board, 0, results);
        return new ArrayList<>(results);
    }

    private void dfs(char[][] board, int row, List<List<String>> results) {
        if (row == board.length) {
            results.add(format(board));
            return;
        }

        for (int j = 0; j < board[row].length; j++) {
            if (validMove(board, row, j)) {
                board[row][j] = 'Q';
                dfs(board, row + 1, results);
                board[row][j] = '.';
            }
        }
    }

    private List<String> format(char[][] board) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

    private boolean validMove(char[][] board, int i, int j) {
        for (char[] row : board) {
            if (row[j] == 'Q') {
                return false;
            }
        }
        for (int k = 1; k <= i; k++) {
            if (j - k >= 0 && board[i - k][j - k] == 'Q') {
                return false;
            }
            if (j + k < board[i - k].length && board[i - k][j + k] == 'Q') {
                return false;
            }
        }
        for (int k = 1; k < board.length - i; k++) {
            if (j - k >= 0 && board[i + k][j - k] == 'Q') {
                return false;
            }
            if (j + k < board[i + k].length && board[i + k][j + k] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
