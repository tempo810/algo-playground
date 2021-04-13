package leetcode;

import leetcode.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class FlipBinaryTreeToMatchPreorderTransversalTest {
    private final FlipBinaryTreeToMatchPreorderTransversal solution = new FlipBinaryTreeToMatchPreorderTransversal();

    @Test
    void flipMatchVoyage() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertThat(solution.flipMatchVoyage(root, new int[]{1, 3, 2}))
                .containsExactly(1);
    }
}
