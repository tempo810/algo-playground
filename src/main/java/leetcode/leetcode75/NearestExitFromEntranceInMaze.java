package leetcode.leetcode75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> steps = new ArrayDeque<>();
        visited[entrance[0]][entrance[1]] = true;
        steps.add(new int[]{entrance[0] - 1, entrance[1]});
        steps.add(new int[]{entrance[0] + 1, entrance[1]});
        steps.add(new int[]{entrance[0], entrance[1] - 1});
        steps.add(new int[]{entrance[0], entrance[1] + 1});
        int currentStep = 1;
        while (!steps.isEmpty()) {
            int currentStepsCount = steps.size();
            for (int i = 0; i < currentStepsCount; i++) {
                final int[] step = steps.poll();
                int n = step[0];
                int m = step[1];
                if (n < 0 || n == maze.length || m < 0 || m == maze[0].length) {
                    continue;
                }
                if (!visited[n][m]) {
                    visited[n][m] = true;
                    if (maze[n][m] == '.') {
                        if (n == 0 || n == maze.length - 1 || m == 0 || m == maze[0].length - 1) {
                            return currentStep;
                        }

                        steps.add(new int[]{n - 1, m});
                        steps.add(new int[]{n + 1, m});
                        steps.add(new int[]{n, m + 1});
                        steps.add(new int[]{n, m - 1});
                    }
                }
            }
            currentStep++;
        }
        return -1;
    }
}
