package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tempo
 */
public class FlipBinaryTreeToMatchPreorderTransversal {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> flippedNodes = new ArrayList<>();
        Queue<Integer> preorderNodes = new ArrayDeque<>();
        for (int i : voyage) {
            preorderNodes.add(i);
        }
        helper(root, preorderNodes, flippedNodes);
        if (preorderNodes.isEmpty()) {
            return flippedNodes;
        }
        return List.of(-1);
    }

    private void helper(TreeNode root, Queue<Integer> preorderNodes, List<Integer> flippedNodes) {
        if (preorderNodes.isEmpty() || root == null || root.val != preorderNodes.peek()) {
            return;
        }

        preorderNodes.remove();
        if (preorderNodes.isEmpty()) {
            return;
        }

        if (root.right != null && root.right.val == preorderNodes.peek()) {
            if (root.left != null) {
                flippedNodes.add(root.val);
            }
            helper(root.right, preorderNodes, flippedNodes);
            helper(root.left, preorderNodes, flippedNodes);

        } else if (root.left != null && root.left.val == preorderNodes.peek()) {
            helper(root.left, preorderNodes, flippedNodes);
            helper(root.right, preorderNodes, flippedNodes);
        }
    }
}
