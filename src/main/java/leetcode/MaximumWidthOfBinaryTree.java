package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author Tempo
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Map<TreeNode, Integer> index = new HashMap<>();
        queue.add(root);
        index.put(root, 1);

        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = -1;
            int end = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                Integer currentIndex = index.get(node);
                if (start == -1) {
                    start = currentIndex;
                }

                end = currentIndex;

                if (node.left != null) {
                    queue.add(node.left);
                    index.put(node.left, currentIndex * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index.put(node.right, currentIndex * 2 + 1);
                }
            }

            maxWidth = Math.max(end - start + 1, maxWidth);
        }
        return maxWidth;
    }
}
