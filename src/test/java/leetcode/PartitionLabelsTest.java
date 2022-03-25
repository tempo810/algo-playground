package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class PartitionLabelsTest {
    private final PartitionLabels solution = new PartitionLabels();

    @Test
    void partitionLabels() {
        Assertions.assertThat(solution.partitionLabels("ababcbacadefegdehijhklij")).containsExactly(9, 7, 8);
    }
}
