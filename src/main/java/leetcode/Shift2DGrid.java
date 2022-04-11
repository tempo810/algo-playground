package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<int[]> shiftedRows = shiftRow(grid, k);
        int shiftCol = k % grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < shiftedRows.size(); i++) {
            int[] prevRow = shiftedRows.get(i == 0 ? shiftedRows.size() - 1 : i - 1);
            List<Integer> transformedRow = new ArrayList<>();
            for (int j = shiftCol; j > 0; j--) {
                transformedRow.add(prevRow[prevRow.length - j]);
            }

            int[] currentRow = shiftedRows.get(i);
            for (int j = 0; j < grid[0].length - shiftCol; j++) {
                transformedRow.add(currentRow[j]);
            }
            result.add(transformedRow);
        }
        return result;
    }

    private List<int[]> shiftRow(int[][] grid, int k) {
        int shiftRow = (k / grid[0].length) % grid.length;
        List<int[]> transformedGrid = new ArrayList<>(grid.length);
        for (int i = shiftRow; i > 0; i--) {
            transformedGrid.add(grid[grid.length - i]);
        }
        for (int i = 0; i < (grid.length - shiftRow); i++) {
            transformedGrid.add(grid[i]);
        }
        return transformedGrid;
    }
}
