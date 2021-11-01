package leetcode;

/**
 * @author Tempo
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                mark(i, 1, board);
            }
            if (board[i][board[i].length - 1] == '0') {
                mark(i, board[i].length - 2, board);
            }
        }
        for (int i = 1; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                mark(1, i, board);
            }
            if (board[board.length - 1][i] == 'O') {
                mark(board.length - 2, i, board);
            }
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(int row, int col, char[][] board) {
        if (row > 0 && row < board.length - 1 && col > 0 && col < board[row].length - 1) {
            if (board[row][col] == 'O') {
                board[row][col] = 'B';
                mark(row - 1, col, board);
                mark(row + 1, col, board);
                mark(row, col - 1, board);
                mark(row, col + 1, board);
            }
        }
    }
}
