package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class CountInversionTest {

    @Test
    void count() {
        assertThat(CountInversion.count(new int[]{2, 3, 8, 6, 1})).isEqualTo(5);
    }
}
