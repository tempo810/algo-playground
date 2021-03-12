package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Tempo
 */
class DailyTemperatureTest {
    private final DailyTemperature solution = new DailyTemperature();

    @Test
    void test() {
        assertThat(solution.dailyTempV2(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}), Matchers.is(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0}));
    }
}
