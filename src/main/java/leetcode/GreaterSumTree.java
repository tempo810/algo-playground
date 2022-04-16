package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class GreaterSumTree {
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            greaterSum2(root, 0);
        }
        return root;
    }

    private int greaterSum2(TreeNode root, int sum) {
        root.val += root.right == null ? sum : greaterSum2(root.right, sum);
        return root.left != null ? greaterSum2(root.left, root.val) : root.val;
    }
}
