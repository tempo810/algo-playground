package leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int goodOrange = 0;
        int numberOfMinutes = 0;
        Queue<int[]> rottenOranges = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        // 0 = empty cell, 1 = fresh , 2 = rotten
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    goodOrange++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!rottenOranges.isEmpty() && goodOrange > 0) {
            int sizeToPoll = rottenOranges.size();
            for (int i = 0; i < sizeToPoll; i++) {
                final int[] rottenOrange = rottenOranges.poll();
                for (int[] dir : dirs) {
                    int newRow = rottenOrange[0] + dir[0];
                    int newCol = rottenOrange[1] + dir[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                        if (grid[newRow][newCol] == 1) {
                            grid[newRow][newCol] = 2;
                            goodOrange--;
                            rottenOranges.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }
            numberOfMinutes++;
        }
        return goodOrange == 0 ? numberOfMinutes : -1;
    }
}
