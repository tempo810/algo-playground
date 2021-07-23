package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class ValidIPAddressTest {
    private final ValidIPAddress solution = new ValidIPAddress();

    @Test
    void validIPAddress() {
        assertThat(solution.validIPAddress("192.168.1.1")).isEqualTo("IPV4");
        assertThat(solution.validIPAddress("255.255.255.255")).isEqualTo("IPV4");
        assertThat(solution.validIPAddress("256.0.0.0")).isEqualTo("NEITHER");
        assertThat(solution.validIPAddress("0.0.0.0")).isEqualTo("IPV4");
        assertThat(solution.validIPAddress("01.0.0.0")).isEqualTo("NEITHER");
        assertThat(solution.validIPAddress("1.0.0.00")).isEqualTo("NEITHER");
        assertThat(solution.validIPAddress("0.0.0.01")).isEqualTo("NEITHER");

    }
}
