package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ValidSudokuTest {
    private final ValidSudoku solution = new ValidSudoku();

    @Test
    void isValidSudoku() {
        char[][] sudoku = new char[9][];
        sudoku[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        sudoku[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        sudoku[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        sudoku[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        sudoku[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        sudoku[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        sudoku[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        sudoku[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        sudoku[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        assertThat(solution.isValidSudoku(sudoku)).isTrue();

        char[][] sudoku2 = new char[9][];
        sudoku2[0] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '2'};
        sudoku2[1] = new char[]{'.', '.', '.', '.', '.', '.', '6', '.', '.'};
        sudoku2[2] = new char[]{'.', '.', '1', '4', '.', '.', '8', '.', '.'};
        sudoku2[3] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        sudoku2[4] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        sudoku2[5] = new char[]{'.', '.', '.', '.', '3', '.', '.', '.', '.'};
        sudoku2[6] = new char[]{'5', '.', '8', '6', '.', '.', '.', '.', '.'};
        sudoku2[7] = new char[]{'.', '9', '.', '.', '.', '.', '4', '.', '.'};
        sudoku2[8] = new char[]{'.', '.', '.', '.', '5', '.', '.', '.', '.'};
        assertThat(solution.isValidSudoku(sudoku2)).isTrue();
    }
}
