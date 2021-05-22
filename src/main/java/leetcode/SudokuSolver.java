package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class SudokuSolver {
    private final Set<Character> CANDIDATES = Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9');

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

        Set<Character> candidates = new HashSet<>(CANDIDATES);
        for (int i = 0; i < 9; i++) {
            candidates.remove(board[row][i]);
            candidates.remove(board[i][col]);
        }
        int squareX = col / 3 * 3;
        int squareY = row / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                candidates.remove(board[i + squareY][j + squareX]);
            }
        }

        for (Character candidate : candidates) {
            board[row][col] = candidate;
            if (col == 8 ? solve(board, row + 1, 0) : solve(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }
}
