package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Tempo
 */
public class LevelOrderTransversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        LinkedList<List<Integer>> results = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> levelElements = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();
                levelElements.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            results.addFirst(levelElements);
        }

        return results;
    }

    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(root, 0, results);
        return results;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        dfs(root.left, level + 1, results);
        dfs(root.right, level + 1, results);
        results.get(level).add(root.val);
    }
}
