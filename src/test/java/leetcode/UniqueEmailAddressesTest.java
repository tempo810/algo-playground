package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class UniqueEmailAddressesTest {
    private final UniqueEmailAddresses solution = new UniqueEmailAddresses();

    @Test
    void numUniqueEmails() {
        assertThat(solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"})).isEqualTo(2);
        assertThat(solution.numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"})).isEqualTo(3);
    }
}
