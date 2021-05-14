package leetcode;

import leetcode.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class FlattenBinaryTreeToLinkedListTest {
    private final FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

    @Test
    void flatten() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        solution.flatten(root);


        System.out.println("done");
    }
}
