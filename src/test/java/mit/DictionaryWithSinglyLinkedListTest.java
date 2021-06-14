package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class DictionaryWithSinglyLinkedListTest {

    @Test
    void dictOperation() {
        var dict = new DictionaryWithSinglyLinkedList();
        assertThat(dict.search("a")).isNull();
        dict.insert("a");
        dict.insert("b");
        dict.insert("c");
        assertThat(dict.search("c"))
                .satisfies(node -> assertThat(node.element).isEqualTo("c"))
                .satisfies(node -> assertThat(node.next.element).isEqualTo("b"));

        assertThat(dict.delete("d")).isFalse();
        assertThat(dict.delete("b")).isTrue();

        assertThat(dict.search("c"))
                .satisfies(node -> assertThat(node.element).isEqualTo("c"))
                .satisfies(node -> assertThat(node.next.element).isEqualTo("a"));

        assertThat(dict.delete("a")).isTrue();
        assertThat(dict.search("c"))
                .satisfies(node -> assertThat(node.element).isEqualTo("c"))
                .satisfies(node -> assertThat(node.next).isNull());

        dict.insert("d");
        assertThat(dict.search("d"))
                .satisfies(node -> assertThat(node.element).isEqualTo("d"))
                .satisfies(node -> assertThat(node.next.element).isEqualTo("c"));
    }
}
