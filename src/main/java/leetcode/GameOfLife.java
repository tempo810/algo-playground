package leetcode;

/**
 * @author Tempo
 */
public class GameOfLife {
    private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}};

    public void gameOfLife(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int livingNeighbour = countLivingNeighbour(board, row, col);
                if ((livingNeighbour > 3 || livingNeighbour < 2) && board[row][col] == 1) {
                    board[row][col] = -1;
                } else if (livingNeighbour == 3 && board[row][col] == 0) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private int countLivingNeighbour(int[][] board, int row, int col) {
        int livingNeighbour = 0;
        for (int[] direction : DIRECTIONS) {
            int neighbourRow = row + direction[0];
            int neighbourCol = col + direction[1];
            if (neighbourRow >= 0 && neighbourRow < board.length && neighbourCol >= 0 && neighbourCol < board[row].length) {
                int neighbourValue = board[neighbourRow][neighbourCol];
                if (neighbourValue == -1 || neighbourValue == 1) {
                    livingNeighbour++;
                }
            }
        }
        return livingNeighbour;
    }

    public void gameOfLifeDfs(int[][] board) {
        gameOfLifeDfs(board, 0, 0);
    }

    private void gameOfLifeDfs(int[][] board, int row, int col) {
        if (row == board.length) {
            return;
        }
        int livingNeighbour = countNeighbour(board, row, col);
        if (col < board[row].length - 1) {
            gameOfLifeDfs(board, row, col + 1);
        } else {
            gameOfLifeDfs(board, row + 1, 0);
        }

        if (livingNeighbour < 2 || livingNeighbour > 3) {
            board[row][col] = 0;
        } else if (livingNeighbour == 3) {
            board[row][col] = 1;
        }
    }

    private int countNeighbour(int[][] board, int row, int col) {
        int living = 0;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[row].length) {
                living += board[nextRow][nextCol];
            }
        }
        return living;
    }
}
