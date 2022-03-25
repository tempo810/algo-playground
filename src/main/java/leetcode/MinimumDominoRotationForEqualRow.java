package leetcode;

/**
 * @author Tempo
 */
public class MinimumDominoRotationForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minRotation = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int topCount = 0;
            int bottomsCount = 0;
            boolean found = true;
            for (int j = 0; j < tops.length && found; j++) {
                if (tops[j] == i || bottoms[j] == i) {
                    if (tops[j] == i) topCount++;
                    if (bottoms[j] == i) bottomsCount++;
                } else {
                    found = false;
                }
            }
            if (found) {
                minRotation = Math.min(minRotation, 6 - Math.max(topCount, bottomsCount));
            }
        }

        return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
    }
}
