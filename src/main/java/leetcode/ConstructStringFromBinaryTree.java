package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        formatPreorder(root, sb);
        return sb.toString();
    }

    private void formatPreorder(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(');
            if (root.left != null) {
                formatPreorder(root.left, sb);
            }
            sb.append(')');
            if (root.right != null) {
                sb.append('(');
                formatPreorder(root.right, sb);
                sb.append(')');
            }
        }
    }
}
