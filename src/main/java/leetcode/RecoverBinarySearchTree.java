package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        int firstIndex = -1;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                firstIndex = i;
                break;
            }
        }
        int smallestIndex = firstIndex + 1;
        for (int i = smallestIndex + 1; i < nodes.size(); i++) {
            if (nodes.get(i).val < nodes.get(smallestIndex).val) {
                smallestIndex = i;
            }
        }
        nodes.get(firstIndex).val ^= nodes.get(smallestIndex).val;
        nodes.get(smallestIndex).val ^= nodes.get(firstIndex).val;
        nodes.get(firstIndex).val ^= nodes.get(smallestIndex).val;
    }

    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root.left != null) {
            inorder(root.left, nodes);
        }
        nodes.add(root);
        if (root.right != null) {
            inorder(root.right, nodes);
        }
    }
}
