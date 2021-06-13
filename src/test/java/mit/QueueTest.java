package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class QueueTest {


    @Test
    void queue() {
        var queue = new Queue(3);
        assertThatThrownBy(queue::deque).hasMessageContaining("empty");

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertThatThrownBy(() -> queue.enqueue(4)).hasMessageContaining("full");
        assertThat(queue.deque()).isEqualTo(1);
        assertThat(queue.deque()).isEqualTo(2);
        assertThat(queue.deque()).isEqualTo(3);
        assertThatThrownBy(queue::deque).hasMessageContaining("empty");

        queue.enqueue(4);
        assertThat(queue.deque()).isEqualTo(4);
    }
}
