package leetcode.top;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tempo
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.add(root, result);
        return result;
    }

    private void add(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            this.add(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            this.add(root.right, result);
        }
    }

    public List<Integer> bfsInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !nodes.isEmpty()) {
            while (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }
            final TreeNode leftMostNode = nodes.pop();
            result.add(leftMostNode.val);
            currentNode = leftMostNode.right;


        }
        return result;
    }
}
