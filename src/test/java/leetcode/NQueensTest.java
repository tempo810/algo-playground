package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Tempo
 */
class NQueensTest {
    private final NQueens solution = new NQueens();

    @Test
    void solveNQueens() {
        List<List<String>> lists = solution.solveNQueens(5);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
