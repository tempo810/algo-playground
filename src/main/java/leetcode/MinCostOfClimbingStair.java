package leetcode;

/**
 * @author Tempo
 */
public class MinCostOfClimbingStair {
    public int minCostClimbingStairs(int[] cost) {
        int take = 0;
        int skip = 0;
        for (int i : cost) {
            int currentStep = Math.min(take, skip) + i;
            skip = take;
            take = currentStep;
        }
        return Math.min(take, skip);
    }
}
