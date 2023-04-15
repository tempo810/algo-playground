package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author tempo
 */
class MaxValueOfKCoinsFromPilesTest {
    private final MaxValueOfKCoinsFromPiles solution = new MaxValueOfKCoinsFromPiles();

    @Test
    void maxValueOfCoins() {
        final List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(Arrays.asList(1, 100, 3));
        arrayList.add(Arrays.asList(7, 8, 9));
        Assertions.assertThat(solution.maxValueOfCoins(arrayList, 2)).isEqualTo(101);
    }
}
