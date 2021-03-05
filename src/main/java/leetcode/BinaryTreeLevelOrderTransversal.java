package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class BinaryTreeLevelOrderTransversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        transverse(root, 0, results);
        return results;
    }

    private void transverse(TreeNode root, int depth, List<List<Integer>> results) {
        if (root != null) {
            if (results.size() <= depth) {
                results.add(new ArrayList<>());
            }
            results.get(depth).add(root.val);
            transverse(root.left, depth + 1, results);
            transverse(root.right, depth + 1, results);
        }
    }
}
