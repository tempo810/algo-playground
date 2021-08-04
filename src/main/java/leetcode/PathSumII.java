package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            dfs(root, targetSum, new ArrayList<>(), result);
        }
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> partial, List<List<Integer>> result) {
        partial.add(root.val);
        int target = targetSum - root.val;

        if (root.left == null && root.right == null) {
            if (target == 0) {
                result.add(List.copyOf(partial));
            }
        }

        if (root.left != null) {
            dfs(root.left, target, partial, result);
        }
        if (root.right != null) {
            dfs(root.right, target, partial, result);
        }
        partial.remove(partial.size() - 1);
    }
}
