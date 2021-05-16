package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class BinaryTreeCameras {
    int ret = 0;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? 1 + ret : ret;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            ret++;
            return 1;
        }
        return left == 1 || right == 1 ? -1 : 0;
    }
}
