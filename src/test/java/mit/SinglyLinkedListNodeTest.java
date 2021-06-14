package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tempo
 */
class SinglyLinkedListNodeTest {

    @Test
    void flip() {
        SinglyLinkedListNode<Integer> root = new SinglyLinkedListNode<>(1);
        root.next = new SinglyLinkedListNode<>(2);
        root.next.next = new SinglyLinkedListNode<>(3);
        root.next.next.next = new SinglyLinkedListNode<>(4);

        SinglyLinkedListNode<Integer> result = SinglyLinkedListNode.flip(root);
        assertThat(result.element).isEqualTo(4);
        assertThat(result.next.element).isEqualTo(3);
        assertThat(result.next.next.element).isEqualTo(2);
        assertThat(result.next.next.next.element).isEqualTo(1);
        assertThat(result.next.next.next.next).isNull();
    }
}
