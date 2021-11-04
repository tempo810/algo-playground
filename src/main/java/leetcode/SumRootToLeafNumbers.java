package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return solve(root, 0);
    }

    private int solve(TreeNode root, int sum) {
        int currentSum = sum * 10 + root.val;
        int childSum = 0;
        if (root.left != null) {
            childSum += solve(root.left, currentSum);
        }
        if (root.right != null) {
            childSum += solve(root.right, currentSum);

        }
        return childSum == 0 ? currentSum : childSum;
    }
}
