package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class MaximumProductSumOfSplittedArray {
    public int maxProduct(TreeNode root) {
        int sum = sum(root);
        int[] result = new int[]{Integer.MIN_VALUE};
        maxProduct(root, sum, result);
        return result[0];
    }

    private int maxProduct(TreeNode root, int sum, int[] max) {
        if (root == null) {
            return 0;
        }

        int current = root.val + maxProduct(root.left, sum, max) + maxProduct(root.right, sum, max);
        max[0] = Math.max(max[0], (int) ((sum - current) * current % 1000000007L));
        return current;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
