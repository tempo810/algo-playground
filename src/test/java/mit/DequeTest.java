package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class DequeTest {
    @Test
    void deque() {
        var deque = new Deque(5);
        deque.headEnqueue(1);
        deque.tailEnqueue(2);
        deque.headEnqueue(3);
        deque.tailEnqueue(4);
        deque.headEnqueue(5);

        assertThatThrownBy(() -> deque.headEnqueue(10)).hasMessageContaining("full");
        assertThatThrownBy(() -> deque.tailEnqueue(10)).hasMessageContaining("full");

        assertThat(deque.tailDeque()).isEqualTo(4);
        assertThat(deque.headDeque()).isEqualTo(5);
        assertThat(deque.headDeque()).isEqualTo(3);
        assertThat(deque.headDeque()).isEqualTo(1);
        assertThat(deque.tailDeque()).isEqualTo(2);
    }
}
