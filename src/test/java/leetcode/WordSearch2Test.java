package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class WordSearch2Test {
    private final WordSearch2 solution = new WordSearch2();

    @Test
    void findWords() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}};
        assertThat(solution.findWords(board, "oath", "pea", "eat", "rain")).containsExactlyInAnyOrder("eat", "oath");
    }
}
