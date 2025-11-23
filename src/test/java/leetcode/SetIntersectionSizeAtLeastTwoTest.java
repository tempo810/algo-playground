package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class SetIntersectionSizeAtLeastTwoTest {
    private SetIntersectionSizeAtLeastTwo setIntersectionSizeAtLeastTwo;

    @BeforeEach
    void setUp() {
        this.setIntersectionSizeAtLeastTwo = new SetIntersectionSizeAtLeastTwo();
    }

    @Test
    void intersectionSizeTwo() {
//        Assertions.assertThat(this.setIntersectionSizeAtLeastTwo.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}})).isEqualTo(5);
//        Assertions.assertThat(this.setIntersectionSizeAtLeastTwo.intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}})).isEqualTo(5);
        Assertions.assertThat(this.setIntersectionSizeAtLeastTwo.intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {8, 9}})).isEqualTo(5);
    }
}