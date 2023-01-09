package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tempo
 */
public class BinaryTreePreorderTransversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> result = new ArrayList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node != null) {
                result.add(node.val);
                nodes.add(node.right);
                nodes.add(node.left);
            }
        }

        return result;
    }

}
