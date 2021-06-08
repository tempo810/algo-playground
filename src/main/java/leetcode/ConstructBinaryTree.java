package leetcode;

import leetcode.datastructure.TreeNode;

/**
 * @author Tempo
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preorderIndex, int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderIndex >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        if (inorder[inorderStart] == preorder[preorderIndex]) {
            root.right = dfs(preorder, preorderIndex + 1, inorder, inorderStart + 1, inorderEnd);
            return root;
        }
        if (inorder[inorderEnd] == preorder[preorderIndex]) {
            root.left = dfs(preorder, preorderIndex + 1, inorder, inorderStart, inorderEnd - 1);
            return root;
        }
        for (int i = inorderStart + 1; i < inorderEnd; i++) {
            if (inorder[i] == preorder[preorderIndex]) {
                root.left = dfs(preorder, preorderIndex + 1, inorder, inorderStart, i - 1);
                root.right = dfs(preorder, preorderIndex + 2, inorder, i + 1, inorderEnd);
                return root;
            }
        }
        return null;
    }
}
