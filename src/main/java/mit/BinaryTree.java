package mit;

import leetcode.datastructure.TreeNode;

import java.util.Stack;

/**
 * @author Tempo
 */
public class BinaryTree {
    // 10.4-2
    public static void printTreeRecursive(TreeNode root) {
        if (root != null) {
            printTreeRecursive(root.left);
            System.out.println(root.val);
            printTreeRecursive(root.right);
        }
    }

    // 10.4-3
    public static void printTree(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            while (nodes.peek().left != null) {
                nodes.push(nodes.peek().left);
            }
            TreeNode currentNode = nodes.pop();
            System.out.println(currentNode.val);
            nodes.push(currentNode.right);
        }
    }
}
