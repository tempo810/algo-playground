package mit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Tempo
 */
class PolynomialEvaluationTest {

    @Test
    void naiveEval() {
        assertThat(PolynomialEvaluation.naiveEval(new int[]{2, -6, 2, -1}, 3), is(5));
        assertThat(PolynomialEvaluation.naiveEval(new int[]{2, 0, 3, 1}, 2), is(23));

        assertThat(PolynomialEvaluation.hornerMethod(new int[]{2, -6, 2, -1}, 3), is(5));
        assertThat(PolynomialEvaluation.hornerMethod(new int[]{2, 0, 3, 1}, 2), is(23));
    }
}
