package leetcode;

/**
 * @author Tempo
 */
public class PartitionToKEqualSumSubset {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0 || nums.length < k) {
            return false;
        }

        boolean[] visited = new boolean[nums.length];
        return find(nums, sum / k, 0, 0, k, visited);
    }

    private boolean find(int[] nums, int targetSum, int currentSum, int index, int numOfSubset, boolean[] visited) {
        if (numOfSubset == 0) {
            return true;
        }
        if (targetSum == currentSum) {
            return find(nums, targetSum, 0, 0, numOfSubset - 1, visited);
        }

        if (currentSum > targetSum) {
            return false;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (find(nums, targetSum, currentSum + nums[i], i + 1, numOfSubset, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
