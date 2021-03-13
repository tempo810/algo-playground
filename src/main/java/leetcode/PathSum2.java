package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Tempo
 */
public class PathSum2 {
    public List<List<Integer>> pathSumBacktracking(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Integer> partial = new ArrayDeque<>();
        findPathSum(root, targetSum, partial, result);
        return result;
    }

    private void findPathSum(TreeNode root, int targetSum, Deque<Integer> partial, List<List<Integer>> result) {
        partial.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                result.add(new ArrayList<>(partial));
            }
        } else {
            if (root.left != null) {
                findPathSum(root.left, targetSum - root.val, partial, result);
            }
            if (root.right != null) {
                findPathSum(root.right, targetSum - root.val, partial, result);
            }
        }
        partial.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        if (root.right == null && root.left == null) {
            if (targetSum == root.val) {
                List<Integer> result = new ArrayList<>();
                result.add(root.val);
                results.add(result);
            }
            return results;
        }

        if (root.right != null) {
            results.addAll(pathSum(root.right, targetSum - root.val));
        }
        if (root.left != null) {
            results.addAll(pathSum(root.left, targetSum - root.val));
        }

        for (List<Integer> path : results) {
            path.add(0, root.val);
        }
        return results;
    }
}
