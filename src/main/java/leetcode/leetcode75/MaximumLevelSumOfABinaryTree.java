package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tempo
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;
        if (root != null) {
            nodes.add(root);
        }
        int result = 0;
        int currentLevel = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                final TreeNode node = nodes.poll();
                levelSum += node.val;
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            currentLevel++;
            if (levelSum > maxSum) {
                maxSum = levelSum;
                result = currentLevel;
            }
        }
        return result;
    }
}
