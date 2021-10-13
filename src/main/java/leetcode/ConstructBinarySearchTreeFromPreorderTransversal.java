package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class ConstructBinarySearchTreeFromPreorderTransversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        int index = 1;
        while (index < preorder.length) {
            TreeNode node = new TreeNode(preorder[index]);
            if (node.val < nodes.peek().val) {
                nodes.peek().left = node;
            } else {
                TreeNode currentNode = nodes.pop();
                while (!nodes.isEmpty() && nodes.peek().val < node.val) {
                    currentNode = nodes.pop();
                }
                currentNode.right = node;
            }
            nodes.add(node);
            index++;
        }
        return root;
    }

    public TreeNode bstFromPreorderRecursive(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }
        int pivot = left + 1;
        while (pivot <= right && preorder[pivot] < root.val) {
            pivot++;
        }
        root.left = dfs(preorder, left + 1, pivot);
        root.right = dfs(preorder, pivot + 1, right);
        return root;
    }
}
