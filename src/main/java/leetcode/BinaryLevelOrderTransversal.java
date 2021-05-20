package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class BinaryLevelOrderTransversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preOrder(root, result, 1);
        return result;
    }

    private void preOrder(TreeNode root, List<List<Integer>> result, int depth) {
        if (root != null) {
            if (result.size() < depth) {
                result.add(new ArrayList<>());
            }
            result.get(depth - 1).add(root.val);
            preOrder(root.left, result, depth + 1);
            preOrder(root.right, result, depth + 1);
        }
    }
}
