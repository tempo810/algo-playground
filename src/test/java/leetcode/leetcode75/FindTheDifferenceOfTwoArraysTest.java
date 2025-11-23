package leetcode.leetcode75;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author tempo
 */
class FindTheDifferenceOfTwoArraysTest {
    private FindTheDifferenceOfTwoArrays findTheDifferenceOfTwoArrays;

    @BeforeEach
    void setUp() {
        findTheDifferenceOfTwoArrays = new FindTheDifferenceOfTwoArrays();
    }

    @Test
    void findDifference() {
        Assertions.assertThat(findTheDifferenceOfTwoArrays.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6})).isEqualTo(List.of(List.of(1, 3), List.of(4, 6)));
    }
}