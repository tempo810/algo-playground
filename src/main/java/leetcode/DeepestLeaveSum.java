package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class DeepestLeaveSum {
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        dfs(0, root, ints);
        return ints.isEmpty() ? 0 : ints.get(ints.size() - 1);
    }

    private void dfs(int depth, TreeNode root, List<Integer> ints) {
        if (root != null) {
            if (ints.size() == depth) {
                ints.add(root.val);
            } else {
                ints.set(depth, ints.get(depth) + root.val);
            }
            dfs(depth + 1, root.left, ints);
            dfs(depth + 1, root.right, ints);
        }
    }
}
