package leetcode.top;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class SubsetTest {
    private Subset subset;

    @BeforeEach
    void setUp() {
        this.subset = new Subset();
    }

    @Test
    void subsets() {
        Assertions.assertThat(this.subset.subsets(new int[]{1, 2, 3}));
    }
}