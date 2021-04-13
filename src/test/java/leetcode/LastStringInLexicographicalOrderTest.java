package leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * @author Tempo
 */
// wip
class LastStringInLexicographicalOrderTest {
    private final LastStringInLexicographicalOrder solution = new LastStringInLexicographicalOrder();
    private String input;

    @BeforeEach
    void setup() throws IOException, URISyntaxException {
        FileInputStream lastSubstringLastSubstring = new FileInputStream(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("LastSubstring")).toURI()));
        input = new String(lastSubstringLastSubstring.readAllBytes());
        lastSubstringLastSubstring.close();
    }

    @Test
    void lastSubstring() {
    }
}
