package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class AverageLevelBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        dfs(root, 0, results, counts);

        for (int i = 0; i < results.size(); i++) {
            results.set(i, results.get(i) / counts.get(i));
        }
        return results;
    }

    private void dfs(TreeNode root, int depth, List<Double> sum, List<Integer> count) {
        if (root != null) {
            if (sum.size() <= depth) {
                sum.add(0D);
                count.add(0);
            }
            sum.set(depth, sum.get(depth) + root.val);
            count.set(depth, count.get(depth) + 1);
            dfs(root.left, depth + 1, sum, count);
            dfs(root.right, depth + 1, sum, count);
        }
    }
}
