package leetcode;

/**
 * @author Tempo
 */
public class MinSideStep {
    public int minSideJumps(int[] obstacles) {
        int[] currentStep = new int[3];
        currentStep[0] = 1;
        currentStep[2] = 1;
        return dfs(0, obstacles, currentStep, 0);
    }

    private int dfs(int index, int[] obstacles, int[] currentStep, int currentMinStep) {
        if (index == obstacles.length) {
            return currentMinStep;
        }


        int obstacleLane = obstacles[index] - 1;
        if (obstacleLane != -1) {
            currentStep[obstacleLane] = Integer.MAX_VALUE;
        }

        int minStep = Integer.MAX_VALUE;
        for (int i : currentStep) {
            minStep = Math.min(minStep, i);
        }

        for (int i = 0; i < currentStep.length; i++) {
            if (i != obstacleLane && currentStep[i] == Integer.MAX_VALUE) {
                currentStep[i] = minStep + 1;
            }
        }


        return dfs(index + 1, obstacles, currentStep, minStep);
    }
}
