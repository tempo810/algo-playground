package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        List<Long> currentPathSumOccurrence = new ArrayList<>();
        return pathSum(root, targetSum, currentPathSumOccurrence);
    }

    private int pathSum(TreeNode root, int targetSum, List<Long> currentPathSumOccurrence) {
        if (root == null) {
            return 0;
        }
        currentPathSumOccurrence.replaceAll(integer -> integer + root.val);
        currentPathSumOccurrence.add((long) root.val);
        int totalCount = pathSum(root.left, targetSum, currentPathSumOccurrence);
        totalCount += pathSum(root.right, targetSum, currentPathSumOccurrence);
        currentPathSumOccurrence.remove(currentPathSumOccurrence.size() - 1);
        for (int i = 0; i < currentPathSumOccurrence.size(); i++) {
            final Long value = currentPathSumOccurrence.get(i);
            if (value == targetSum) {
                totalCount++;
            }
            currentPathSumOccurrence.set(i, value - root.val);
        }
        if (root.val == targetSum) totalCount++;
        return totalCount;
    }
}
