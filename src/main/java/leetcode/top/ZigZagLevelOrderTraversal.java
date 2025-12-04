package leetcode.top;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tempo
 */
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> nodes = new Stack<>();
        Queue<TreeNode> tmpQueue = new ArrayDeque<>();
        nodes.add(root);
        boolean fromLeftToRight = true;
        while (!nodes.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            while (!nodes.isEmpty()) {
                final TreeNode currentNode = nodes.pop();
                currentLevel.add(currentNode.val);
                TreeNode firstNode = fromLeftToRight ? currentNode.left : currentNode.right;
                TreeNode secondNode = fromLeftToRight ? currentNode.right : currentNode.left;
                if (firstNode != null) {
                    tmpQueue.add(firstNode);
                }
                if (secondNode != null) {
                    tmpQueue.add(secondNode);
                }
            }
            result.add(currentLevel);
            fromLeftToRight = !fromLeftToRight;
            while (!tmpQueue.isEmpty()) {
                nodes.add(tmpQueue.poll());
            }
        }
        return result;
    }
}
