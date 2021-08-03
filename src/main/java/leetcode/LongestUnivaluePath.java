package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class LongestUnivaluePath {
    private int maxPath = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        int goLeft = 0;
        int goRight = 0;
        if (root.left != null && root.left.val == root.val) {
            goLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            goRight += right + 1;
        }
        maxPath = Math.max(goLeft + goRight, maxPath);
        return Math.max(goLeft, goRight);
    }
}
