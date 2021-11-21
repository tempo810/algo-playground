package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class ConstructBinaryFromInorderPostorderTransversal {
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }
        index = inorder.length - 1;
        return build(postorder, inorderIndices, 0, inorderIndices.size() - 1);
    }

    private TreeNode build(int[] postorder, Map<Integer, Integer> inorderIndices, int inorderStart, int inOrderEnd) {
        if (inorderStart > inOrderEnd || index < 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[index--]);
        int inorderIndex = inorderIndices.get(node.val);
        node.right = build(postorder, inorderIndices, inorderIndex + 1, inOrderEnd);
        node.left = build(postorder, inorderIndices, inorderStart, inorderIndex - 1);
        return node;
    }
}
