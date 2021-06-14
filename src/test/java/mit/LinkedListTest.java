package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class LinkedListTest {

    @Test
    void add() {
        var list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.search(0)).isFalse();
        assertThat(list.search(1)).isTrue();
        assertThat(list.search(2)).isTrue();
        assertThat(list.search(3)).isTrue();
        assertThat(list.search(4)).isFalse();
    }
}
