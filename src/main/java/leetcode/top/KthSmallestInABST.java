package leetcode.top;

import leetcode.datastructure.TreeNode;

/**
 * @author tempo
 */
public class KthSmallestInABST {
    private int nodeCount = 0;

    public int kthSmallest(TreeNode root, int k) {
        return this.find(root, k);
    }

    private Integer find(TreeNode root, int k) {
        final Integer result = root.left == null ? null : this.find(root.left, k);
        if (result != null) {
            return result;
        } else {
            this.nodeCount++;
            if (this.nodeCount == k) {
                return root.val;
            }
        }
        return root.right == null ? null : find(root.right, k);
    }
}
