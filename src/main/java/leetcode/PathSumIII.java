package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        return found(root, 0, targetSum);
    }

    private int found(TreeNode root, int currentSum, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (currentSum + root.val == targetSum) {
            count++;
        }
        count += found(root.left, currentSum + root.val, targetSum);
        count += found(root.right, currentSum + root.val, targetSum);

        return count;
    }
}
