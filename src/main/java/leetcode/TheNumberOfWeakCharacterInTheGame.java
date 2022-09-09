package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class TheNumberOfWeakCharacterInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            int compare = Integer.compare(b[0], a[0]);
            if (compare != 0) return compare;
            return Integer.compare(b[1], a[1]);
        });
        int globalMaxDefense = Integer.MIN_VALUE;
        int currentMaxDefense = properties[0][1];
        int weakCount = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i - 1][0] != properties[i][0]) {
                globalMaxDefense = Math.max(currentMaxDefense, globalMaxDefense);
                currentMaxDefense = properties[i][1];
            }
            if (properties[i][1] < globalMaxDefense) {
                weakCount++;
            }
        }
        return weakCount;
    }
}
