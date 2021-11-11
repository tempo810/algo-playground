package leetcode;

/**
 * @author Tempo
 */
public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int currentMin = 0;
        int globalMin = 0;
        for (int num : nums) {
            currentMin += num;
            globalMin = Math.min(globalMin, currentMin);
        }
        return (currentMin * -1) + 1;
    }
}
