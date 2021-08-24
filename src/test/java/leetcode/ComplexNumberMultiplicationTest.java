package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class ComplexNumberMultiplicationTest {
    private final ComplexNumberMultiplication solution = new ComplexNumberMultiplication();

    @Test
    void complexNumberMultiply() {
        Assertions.assertThat(solution.complexNumberMultiply("1+-1i", "0+0i")).isEqualTo("0+0i");
        Assertions.assertThat(solution.complexNumberMultiply("1+1i", "1+1i")).isEqualTo("0+2i");
        Assertions.assertThat(solution.complexNumberMultiply("1+-1i", "1+-1i")).isEqualTo("0+-2i");
    }
}
