package leetcode;

import leetcode.datastructure.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class CheckCompletenessOfBinaryTreeTest {

    private final CheckCompletenessOfBinaryTree solution = new CheckCompletenessOfBinaryTree();

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Assertions.assertThat(solution.isCompleteTree(root)).isTrue();
    }
}
