package leetcode;

/**
 * @author Tempo
 */
public class PartitionIntoMinimumPartition {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            if (c > max) {
                max = c;
            }
        }
        return max - 48;
    }
}
