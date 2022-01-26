package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return sum(root, 0);
    }

    private int sum(TreeNode root, int sum) {
        sum = (sum << 1) | root.val;
        if (root.right == null && root.left == null) {
            return sum;
        }
        int current = 0;
        if (root.right != null) {
            current += sum(root.right, sum);
        }
        if (root.left != null) {
            current += sum(root.left, sum);
        }
        return current;
    }
}
