package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Tempo
 */
public class SumSumIV {
    public boolean findTargetBFS(TreeNode root, int k) {
        Set<Integer> hashes = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();
                if (hashes.contains(k - node.val)) {
                    return true;
                } else {
                    hashes.add(node.val);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
            }
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numbers = new ArrayList<>();
        inorder(root, numbers);
        int left = 0;
        int right = numbers.size() - 1;
        while (left < right) {
            int sum = numbers.get(left) + numbers.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> numbers) {
        if (root != null) {
            inorder(root.left, numbers);
            numbers.add(root.val);
            inorder(root.right, numbers);
        }
    }
}
