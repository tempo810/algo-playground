package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class StackWith2QueueTest {

    @Test
    void add() {
        var stack = new StackWith2Queue();
        assertThatThrownBy(stack::pop).hasMessageContaining("empty");
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        assertThatThrownBy(stack::pop).hasMessageContaining("empty");
    }
}
