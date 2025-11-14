package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class SumRootToLeafNumber {
    public int sumNumbers(TreeNode root) {
        return sumOf(root, 0);
    }

    private int sumOf(TreeNode root, int lastSum) {
        if (root == null) {
            return 0;
        }
        int currentSum = lastSum * 10 + root.val;
        int lSum = sumOf(root.left, currentSum);
        int rSum = sumOf(root.right, currentSum);
        if (lSum == 0 && rSum == 0) {
            return currentSum;
        }
        return lSum + rSum;
    }
}
