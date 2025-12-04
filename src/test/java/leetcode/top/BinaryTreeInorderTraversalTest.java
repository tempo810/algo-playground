package leetcode.top;

import leetcode.datastructure.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author tempo
 */
class BinaryTreeInorderTraversalTest {
    private BinaryTreeInorderTraversal binaryTreeInorderTraversal;

    @BeforeEach
    void setUp() {
        this.binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
    }

    @Test
    void bfsInorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assertions.assertThat(this.binaryTreeInorderTraversal.bfsInorderTraversal(root)).isEqualTo(List.of(1, 3, 2));
    }
}