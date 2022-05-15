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

    public int deepestLeavesSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = findHeight(root);
        return sum(root, 1, height);
    }

    private int sum(TreeNode root, int depth, int targetDepth) {
        if (root == null) {
            return 0;
        }
        if (depth == targetDepth) {
            return root.val;
        } else {
            return sum(root.left, depth + 1, targetDepth) + sum(root.right, depth + 1, targetDepth);
        }
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
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
