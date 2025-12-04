package leetcode.top;

/**
 * @author tempo
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        Boolean[] canReachFinal = new Boolean[nums.length];
        canReachFinal[nums.length - 1] = true;
        return this.dfs(nums, 0, canReachFinal);
    }

    public boolean canJump2(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i = 0; i < nums.length - 1 && !canReach[canReach.length - 1]; i++) {
            if (canReach[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    canReach[i + j] = true;
                }
            }
        }
        return canReach[canReach.length - 1];
    }

    private boolean dfs(int[] nums, int from, Boolean[] canReachFinal) {
        if (canReachFinal[from] == null) {
            canReachFinal[from] = false;
            for (int i = 1; i <= nums[from] && i + from < nums.length && !canReachFinal[from]; i++) {
                if (this.dfs(nums, from + i, canReachFinal)) {
                    canReachFinal[from] = true;
                }
            }
        }
        return canReachFinal[from];
    }
}
