package leetcode.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class BinaryIndexedTreeTest {

    @Test
    void set() {
        var bit = new BinaryIndexedTree(new int[]{1, 3, 5, 2, 4, 6});
        Assertions.assertThat(bit.get(4)).isEqualTo(15);

        bit.update(3, 6);
        Assertions.assertThat(bit.get(4)).isEqualTo(19);
    }
}
