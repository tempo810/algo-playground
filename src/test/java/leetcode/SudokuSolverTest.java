package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class SudokuSolverTest {
    private final SudokuSolver solver = new SudokuSolver();

    @Test
    void solveSudoku() {
        char[][] input = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solver.solveSudoku(input);
        for (char[] chars : input) {
            System.out.println(new String(chars));
        }

    }
}
