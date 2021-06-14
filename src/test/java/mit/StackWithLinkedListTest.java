package mit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Tempo
 */
class StackWithLinkedListTest {

    @Test
    void stackPushAndPop() {
        var stack = new StackWithLinkedList();
        assertThatThrownBy(stack::pop).hasMessageContaining("empty");

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        assertThatThrownBy(stack::pop).hasMessageContaining("empty");

        stack.push(4);
        assertThat(stack.pop()).isEqualTo(4);
    }
}
