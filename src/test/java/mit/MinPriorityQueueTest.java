package mit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tempo
 */
class MinPriorityQueueTest {
    private MinPriorityQueue minQueue;

    @BeforeEach
    void setup() {
        minQueue = new MinPriorityQueue(12);
    }

    @Test
    void maxElement() {
        minQueue.add(15);
        minQueue.add(13);
        minQueue.add(9);
        minQueue.add(5);
        minQueue.add(12);
        minQueue.add(8);
        minQueue.add(7);
        minQueue.add(4);
        minQueue.add(0);
        minQueue.add(6);
        minQueue.add(2);
        minQueue.add(1);

        assertThat(minQueue.size()).isEqualTo(12);
        assertThat(minQueue.extractMin()).isEqualTo(0);
    }
}
