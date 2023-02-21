package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class NearestExitFromEntranceInMaze {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> steps = new ArrayDeque<>();
        steps.add(entrance);
        int currentStep = 0;
        while (!steps.isEmpty()) {
            int size = steps.size();
            for (int i = 0; i < size; i++) {
                int[] step = steps.poll();
                if (maze[step[0]][step[1]] == '.') {
                    maze[step[0]][step[1]] = '+';
                    for (int[] direction : DIRECTIONS) {
                        final int nextX = step[0] + direction[0];
                        final int nextY = step[1] + direction[1];
                        if (nextX < 0 || nextY < 0 || nextX == maze.length || nextY == maze[0].length) {
                            if (currentStep > 0) {
                                return currentStep;
                            }
                        } else {
                            steps.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            currentStep++;
        }
        return -1;
    }
}
