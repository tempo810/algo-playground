package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class PolynomialEvaluationTest {

    @Test
    void naiveEval() {
        assertThat(PolynomialEvaluation.naiveEval(new int[]{2, -6, 2, -1}, 3)).isEqualTo(5);
        assertThat(PolynomialEvaluation.naiveEval(new int[]{2, 0, 3, 1}, 2)).isEqualTo(23);

        assertThat(PolynomialEvaluation.hornerMethod(new int[]{2, -6, 2, -1}, 3)).isEqualTo(5);
        assertThat(PolynomialEvaluation.hornerMethod(new int[]{2, 0, 3, 1}, 2)).isEqualTo(23);
    }
}
