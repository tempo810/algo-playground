package leetcode;

import leetcode.datastructure.TreeNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat(solution.rob(root), Matchers.is(7));
    }
}
