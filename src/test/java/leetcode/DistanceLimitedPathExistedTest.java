package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class DistanceLimitedPathExistedTest {
    private final DistanceLimitedPathExisted solution = new DistanceLimitedPathExisted();

    @Test
    void distanceLimitedPathsExist() {
        int[][] edges = new int[][]{{9, 1, 53}, {3, 2, 66}, {12, 5, 99}, {9, 7, 26}, {1, 4, 78}, {11, 1, 62}, {3, 10, 50}, {12, 1, 71}, {12, 6, 63}, {1, 10, 63}, {9, 10, 88}, {9, 11, 59}, {1, 4, 37}, {4, 2, 63}, {0, 2, 26}, {6, 12, 98}, {9, 11, 99}, {4, 5, 40}, {2, 8, 25}, {4, 2, 35}, {8, 10, 9}, {11, 9, 25}, {10, 11, 11}, {7, 6, 89},
                {2, 4, 99}, {10, 4, 63}};
        int[][] queries = new int[][]{{9, 7, 65}, {9, 6, 1}, {4, 5, 34}, {10, 8, 43}, {3, 7, 76}, {4, 2, 15}, {7, 6, 52}, {2, 0, 50}, {7, 6, 62}, {1, 0, 81}, {4, 5, 35}, {0, 11, 86}, {12, 5, 50}, {11, 2, 2}, {9, 5, 6}, {12, 0, 95}, {10, 6, 9}, {9, 4, 73}, {6, 10, 48}, {12, 0, 91}, {9, 10, 58}, {9, 8, 73}, {2, 3, 44},
                {7, 11, 83}, {5, 3, 14}, {6, 2, 33}};

        Assertions.assertThat(solution.distanceLimitedPathsExist(13, edges, queries)).containsExactly(true, false, false, true, true, false, false, true, false, true, false, true, false, false, false, true, false, true, false, true, true, true, false, true, false, false);
    }
}
