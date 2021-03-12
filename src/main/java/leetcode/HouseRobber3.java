package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        return helper(root)[0];
    }

    private int[] helper(TreeNode root) {
        int[] partial = new int[2]; // [0] = current optimal, [1] = prev optimal
        if (root != null) {
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            partial[0] = Math.max(root.val + left[1] + right[1], left[0] + right[0]);
            partial[1] = left[0] + right[0];
        }

        return partial;
    }
}
