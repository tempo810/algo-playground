package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tempo
 */
public class DistributedCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> distinctTypes = new HashSet<>();
        for (int candy : candyType) {
            distinctTypes.add(candy);
            if (distinctTypes.size() >= candyType.length / 2) {
                return candyType.length / 2;
            }
        }
        return distinctTypes.size();
    }
}
