package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tempo
 */
public class BSTIterator {
    private final Queue<Integer> nodes;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        buildIndex(root);
    }

    public int next() {
        return nodes.poll();
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    private void buildIndex(TreeNode root) {
        if (root.left != null) {
            buildIndex(root.left);
        }
        nodes.add(root.val);
        if (root.right != null) {
            buildIndex(root.right);
        }
    }
}
