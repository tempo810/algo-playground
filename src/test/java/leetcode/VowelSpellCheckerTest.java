package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class VowelSpellCheckerTest {
    private final VowelSpellChecker solution = new VowelSpellChecker();

    @Test
    void spellchecker() {
        assertThat(solution.spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"}, new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}), Matchers.is(new String[]{}));

    }
}
