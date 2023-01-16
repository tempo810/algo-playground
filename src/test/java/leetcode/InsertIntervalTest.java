package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author tempo
 */
class InsertIntervalTest {
    private final InsertInterval solution = new InsertInterval();

    @Test
    void insert() {
        assertThat(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})).isEqualTo(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    }
}
