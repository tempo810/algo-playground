package leetcode;

/**
 * @author Tempo
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] squareHash = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            int horizontalHash = 0;
            int verticalHash = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if ((horizontalHash & (1 << board[i][j] - 48)) != 0) {
                        return false;
                    } else {
                        horizontalHash |= (1 << board[i][j] - 48);
                    }
                    if ((squareHash[i / 3][j / 3] & (1 << board[i][j] - 48)) != 0) {
                        return false;
                    } else {
                        squareHash[i / 3][j / 3] |= (1 << board[i][j] - 48);
                    }
                }

                if (board[j][i] != '.') {
                    if ((verticalHash & (1 << board[j][i] - 48)) != 0) {
                        return false;
                    } else {
                        verticalHash |= (1 << board[j][i] - 48);
                    }
                }
            }
        }
        return true;
    }
}
