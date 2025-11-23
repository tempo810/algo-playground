package leetcode.leetcode75;

/**
 * @author tempo
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currentAlt = 0;
        for (int alt : gain) {
            currentAlt += alt;
            maxAlt = Math.max(maxAlt, currentAlt);
        }
        return maxAlt;
    }
}
