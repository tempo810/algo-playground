package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class ReorderRouteToMakeAllPathsLeadToCityZeroTest {
    private final ReorderRouteToMakeAllPathsLeadToCityZero solution = new ReorderRouteToMakeAllPathsLeadToCityZero();

    @Test
    void minReorder() {
        Assertions.assertThat(solution.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}})).isEqualTo(2);
    }
}
