package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SearchSuggestionSystemTest {
    private final SearchSuggestionSystem solution = new SearchSuggestionSystem();

    @Test
    void suggestedProducts() {
        assertThat(solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"))
                .containsExactly(
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad")
                );
    }
}
