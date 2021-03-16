package mit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author tempo
 */
class MaxPriorityQueueTest {
    private MaxPriorityQueue maxQueue;

    @BeforeEach
    void setup() {
        maxQueue = new MaxPriorityQueue(12);
    }

    @Test
    void maxElement() {
        maxQueue.add(15);
        maxQueue.add(13);
        maxQueue.add(9);
        maxQueue.add(5);
        maxQueue.add(12);
        maxQueue.add(8);
        maxQueue.add(7);
        maxQueue.add(4);
        maxQueue.add(0);
        maxQueue.add(6);
        maxQueue.add(2);
        maxQueue.add(1);

        assertThat(maxQueue.size(), is(12));
        assertThat(maxQueue.extractMax(), is(15));
    }
}
