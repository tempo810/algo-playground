package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class BinaryTreeFromRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        helper(root, 0, results);
        return results;
    }

    private void helper(TreeNode root, int depth, List<Integer> results) {
        if (root == null) {
            return;
        }

        if (results.size() == depth) {
            results.add(root.val);
        }

        helper(root.right, depth + 1, results);
        helper(root.left, depth + 1, results);
    }
}
