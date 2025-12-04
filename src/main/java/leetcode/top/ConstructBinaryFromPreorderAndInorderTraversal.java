package leetcode.top;

import leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tempo
 */
public class ConstructBinaryFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        Map<Integer, Integer> nodesMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodesMap.put(inorder[i], i);
        }

        TreeNode current = root;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            if (nodesMap.get(preorder[i]) < nodesMap.get(current.val)) {
                current.left = newNode;
            } else {
                TreeNode parent = this.searchParent(root, nodesMap, newNode.val);
                parent.right = newNode;
            }
            current = newNode;
        }
        return root;
    }

    private TreeNode searchParent(TreeNode root, Map<Integer, Integer> nodesMap, int val) {
        TreeNode result = null;
        if (nodesMap.get(root.val) < nodesMap.get(val)) {
            if (root.right != null) {
                result = searchParent(root.right, nodesMap, val);
            }
            if (result == null) {
                result = root;
            }
        } else {
            if (root.left != null) {
                result = searchParent(root.left, nodesMap, val);
            }
        }
        return result;
    }
}
