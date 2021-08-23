package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> integers = new ArrayList<>();
        toOrderedList(root, integers);
        int left = 0;
        int right = integers.size() - 1;
        while (left < right) {
            int result = integers.get(left) + integers.get(right);
            if (result == k) {
                return true;
            }
            if (result < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public boolean findTargetV2(TreeNode root, int k) {
        return search(root, root, k);
    }

    private boolean search(TreeNode root, TreeNode current, int k) {
        if (current == null) {
            return false;
        }
        if (k - current.val != current.val && searchTarget(root, k - current.val)) {
            return true;
        }
        return search(root, current.left, k) || search(root, current.right, k);
    }

    private boolean searchTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        return root.val > k ? searchTarget(root.left, k) : searchTarget(root.right, k);
    }

    private void toOrderedList(TreeNode root, List<Integer> integers) {
        if (root != null) {
            toOrderedList(root.left, integers);
            integers.add(root.val);
            toOrderedList(root.right, integers);
        }
    }
}
