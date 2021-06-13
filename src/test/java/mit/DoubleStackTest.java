package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class DoubleStackTest {

    @Test
    void push() {
        var stack = new DoubleStack(5);

        stack.stack1Push(1);
        stack.stack1Push(2);
        stack.stack1Push(3);
        stack.stack2Push(4);
        stack.stack2Push(5);

        assertThatThrownBy(() -> stack.stack1Push(6));
        assertThatThrownBy(() -> stack.stack2Push(6));
    }

    @Test
    void pop() {
        var stack = new DoubleStack(5);

        stack.stack1Push(1);
        stack.stack1Push(2);
        stack.stack1Push(3);
        stack.stack2Push(4);
        stack.stack2Push(5);

        assertThat(stack.stack1Pop()).isEqualTo(3);
        assertThat(stack.stack2Pop()).isEqualTo(5);
        assertThat(stack.stack1Pop()).isEqualTo(2);
        assertThat(stack.stack2Pop()).isEqualTo(4);
        assertThat(stack.stack1Pop()).isEqualTo(1);

        assertThatThrownBy(stack::stack1Pop);
        assertThatThrownBy(stack::stack2Pop);
    }
}
