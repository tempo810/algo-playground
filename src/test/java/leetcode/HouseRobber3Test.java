package leetcode;

import leetcode.datastructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class HouseRobber3Test {
    private final HouseRobber3 solution = new HouseRobber3();

    @Test
    void rob() {
        var root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        assertThat(solution.rob(root)).isEqualTo(7);
    }
}
