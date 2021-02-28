package mit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Tempo
 */
class CountInversionTest {

    @Test
    void count() {
        assertThat(CountInversion.count(new int[]{2, 3, 8, 6, 1}), is(5));
    }
}
