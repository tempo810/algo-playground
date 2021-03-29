package leetcode;

import leetcode.datastructure.TreeNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat(solution.flipMatchVoyage(root, new int[]{1, 3, 2}), Matchers.is(List.of(1)));
    }
}
