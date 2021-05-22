package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return col == 8 ? solve(board, row + 1, 0) : solve(board, row, col + 1);
        }
        boolean[] candidates = new boolean[9];
        Arrays.fill(candidates, true);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                candidates[board[row][i] - 49] = false;
            }
            if (board[i][col] != '.') {
                candidates[board[i][col] - 49] = false;
            }
        }
        int squareX = col / 3 * 3;
        int squareY = row / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + squareY][j + squareX] != '.') {
                    candidates[board[i + squareY][j + squareX] - 49] = false;
                }
            }
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i]) {
                board[row][col] = (char) (i + 49);
                if (col == 8 ? solve(board, row + 1, 0) : solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';

            }
        }
        return false;
    }
}
