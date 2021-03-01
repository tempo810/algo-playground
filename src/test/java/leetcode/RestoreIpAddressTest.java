package leetcode;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tempo
 */
class RestoreIpAddressTest {
    private final RestoreIpAddress solution = new RestoreIpAddress();

    @Test
    void test() {
        assertThat(solution.restoreIpAddresses("25525511135"), Matchers.containsInAnyOrder("255.255.11.135", "255.255.111.35"));
    }
}
