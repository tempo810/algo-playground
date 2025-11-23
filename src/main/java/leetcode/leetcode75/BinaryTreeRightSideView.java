package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tempo
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightMostValues = new ArrayList<>();
        if (root == null) {
            return rightMostValues;
        }

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            TreeNode rightMostNode = null;
            for (int i = 0; i < size; i++) {
                rightMostNode = nodes.poll();
                if (rightMostNode.left != null) {
                    nodes.add(rightMostNode.left);
                }
                if (rightMostNode.right != null) {
                    nodes.add(rightMostNode.right);
                }
            }
            rightMostValues.add(rightMostNode.val);
        }
        return rightMostValues;
    }
}
