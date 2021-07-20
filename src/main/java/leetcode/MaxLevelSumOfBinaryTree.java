package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class MaxLevelSumOfBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        for (int level = 1; !bfs.isEmpty(); level++) {
            int sum = 0;
            for (int j = bfs.size(); j > 0; j--) {
                TreeNode node = bfs.remove();
                sum += node.val;
                if (node.right != null) {
                    bfs.offer(node.right);
                }
                if (node.left != null) {
                    bfs.offer(node.left);
                }
            }
            if (sum > maxLevelSum) {
                maxLevelSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
