package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ReconstructOriginalDigitsFromEnglishTest {
    private final ReconstructOriginalDigitsFromEnglish solution = new ReconstructOriginalDigitsFromEnglish();

    @Test
    void test() {
        assertThat(solution.originalDigits("owoztneoer")).isEqualTo("012");
    }
}
