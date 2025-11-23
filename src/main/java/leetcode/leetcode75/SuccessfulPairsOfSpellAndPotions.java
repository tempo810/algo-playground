package leetcode.leetcode75;

import java.util.Arrays;

/**
 * @author tempo
 */
public class SuccessfulPairsOfSpellAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        int[][] spellsPairs = new int[spells.length][2];
        for (int i = 0; i < spells.length; i++) {
            spellsPairs[i] = new int[]{spells[i], i};
        }
        Arrays.sort(spellsPairs, (a, b) -> a[0] - b[0]);
        Arrays.sort(potions); // increase
        int right = potions.length - 1;
        for (int i = 0; i < spellsPairs.length; i++) {
            int[] currentSpell = spellsPairs[i];
            right = search(potions, currentSpell[0], success, right);
            result[currentSpell[1]] = potions.length - 1 - right;
        }
        return result;
    }

    private int search(int[] potions, int currentSpell, long target, int lastRight) {
        int left = 0;
        int right = lastRight;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) potions[mid] * currentSpell >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
