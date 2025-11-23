package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class NearestExitFromEntranceInMazeTest {
    private NearestExitFromEntranceInMaze nearestExitFromEntranceInMaze;

    @BeforeEach
    void setUp() {
        this.nearestExitFromEntranceInMaze = new NearestExitFromEntranceInMaze();
    }

    @Test
    void nearestExit() {
        Assertions.assertThat(this.nearestExitFromEntranceInMaze.nearestExit(new char[][]{{'+', '.', '+', '+', '+', '+', '+'}, {'+', '.', '+', '.', '.', '.', '+'}, {'+', '.', '+', '.', '+', '.', '+'}, {'+', '.', '.', '.', '+', '.', '+'}, {'+', '+', '+', '+', '+', '.', '+'}}, new int[]{0, 1})).isEqualTo(12);
    }
}