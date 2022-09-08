package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class BinaryTreeInorderTransversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}
