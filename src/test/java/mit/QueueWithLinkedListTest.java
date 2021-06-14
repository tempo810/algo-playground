package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class QueueWithLinkedListTest {
    @Test
    void queue() {
        var queue = new QueueWithLinkedList();
        assertThatThrownBy(queue::dequeue).hasMessageContaining("empty");

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue.dequeue()).isEqualTo(1);
        assertThat(queue.dequeue()).isEqualTo(2);
        assertThat(queue.dequeue()).isEqualTo(3);
        assertThatThrownBy(queue::dequeue).hasMessageContaining("empty");

        queue.enqueue(4);
        assertThat(queue.dequeue()).isEqualTo(4);
    }

}
