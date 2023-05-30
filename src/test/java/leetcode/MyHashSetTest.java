package leetcode;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author tempo
 */
class MyHashSetTest {
    @Test
    void contains() {
        var hashset = new MyHashSet();
        hashset.add(95);
        Assertions.assertThat(hashset.contains(95)).isTrue();
    }
}
