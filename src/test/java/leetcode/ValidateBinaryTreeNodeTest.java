package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ValidateBinaryTreeNodeTest {
    private final ValidateBinaryTreeNode solution = new ValidateBinaryTreeNode();

    @Test
    void validateBinaryTreeNodes() {
        assertThat(solution.validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1})).isTrue();
    }
}
