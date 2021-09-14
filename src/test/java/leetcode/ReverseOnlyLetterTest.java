package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class ReverseOnlyLetterTest {
    private final ReverseOnlyLetter solution = new ReverseOnlyLetter();

    @Test
    void reverseOnlyLetters() {
        Assertions.assertThat(solution.reverseOnlyLetters("ab-cd")).isEqualTo("dc-ba");
        Assertions.assertThat(solution.reverseOnlyLetters("a-bC-dEf-ghIj")).isEqualTo("j-Ih-gfE-dCba");
        Assertions.assertThat(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!")).isEqualTo("Qedo1ct-eeLg=ntse-T!");
    }
}
