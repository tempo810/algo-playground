package leetcode;

/**
 * @author Tempo
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            boolean[] used = new boolean[nums.length];
            used[i] = true;
            int count = 1;
            int currentNum = nums[i];
            while (!used[currentNum]) {
                used[currentNum] = true;
                currentNum = nums[currentNum];
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public int arrayNestingV2(int[] nums) {
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            int j = i;
            while (nums[j] >= 0) {
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
                current++;
            }
            globalMax = Math.max(globalMax, current);
        }
        return globalMax;
    }
}
