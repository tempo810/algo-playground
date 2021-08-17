package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class CountGoodNode {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int currentMax = Math.max(max, root.val);
        int count = dfs(root.left, currentMax) + dfs(root.right, currentMax);
        return (root.val < currentMax ? 0 : 1) + count;
    }
}
