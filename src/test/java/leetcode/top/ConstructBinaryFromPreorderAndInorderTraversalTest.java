package leetcode.top;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class ConstructBinaryFromPreorderAndInorderTraversalTest {
    private ConstructBinaryFromPreorderAndInorderTraversal constructBinaryFromPreorderAndInorderTraversal;

    @BeforeEach
    void setUp() {
        this.constructBinaryFromPreorderAndInorderTraversal = new ConstructBinaryFromPreorderAndInorderTraversal();
    }

    @Test
    void buildTree() {
        this.constructBinaryFromPreorderAndInorderTraversal.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}