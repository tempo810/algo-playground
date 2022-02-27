package leetcode;

import leetcode.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class MaximumWidthOfBinaryTreeTest {
    private final MaximumWidthOfBinaryTree solution = new MaximumWidthOfBinaryTree();

    @Test
    void widthOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        assertThat(solution.widthOfBinaryTree(root)).isEqualTo(2);
    }
}
