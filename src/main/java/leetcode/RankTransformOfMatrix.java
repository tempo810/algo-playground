package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Tempo
 */
public class RankTransformOfMatrix {
    // WIP
    public int[][] matrixRankTransform(int[][] matrix) {
        TreeMap<Integer, List<Cell>> tree = new TreeMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tree.computeIfAbsent(matrix[i][j], key -> new ArrayList<>()).add(new Cell(i, j));
            }
        }
        int[] maxRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];

        for (Map.Entry<Integer, List<Cell>> entry : tree.entrySet()) {
            Set<Integer> trackedRow = new HashSet<>();
            Set<Integer> trackedCol = new HashSet<>();
            for (Cell cell : entry.getValue()) {
                int current = trackedCol.add(cell.col) ? maxCol[cell.col] + 1 : maxCol[cell.col];
                current = Math.max(current, trackedRow.add(cell.row) ? maxRow[cell.row] + 1 : maxRow[cell.row]);
                maxRow[cell.row] = current;
                maxCol[cell.col] = current;
                matrix[cell.row][cell.col] = current;
            }
        }
        return matrix;
    }

    static class Cell {
        final int row;
        final int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
