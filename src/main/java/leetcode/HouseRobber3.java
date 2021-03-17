package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        int[] partial = new int[2]; //[0] = rob, [1] = noRob
        if (root != null) {
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            partial[0] = Math.max(0, root.val) + left[1] + right[1];
            partial[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        }

        return partial;
    }
}
