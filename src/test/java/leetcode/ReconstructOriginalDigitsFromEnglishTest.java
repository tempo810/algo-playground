package leetcode;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class ReconstructOriginalDigitsFromEnglishTest {
    private final ReconstructOriginalDigitsFromEnglish solution = new ReconstructOriginalDigitsFromEnglish();

    @Test
    void test() {
        MatcherAssert.assertThat(solution.originalDigits("owoztneoer"), Matchers.is("012"));
    }
}
