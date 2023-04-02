package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = findValidPotion(spells[i], potions, success);
        }
        return result;
    }

    private int findValidPotion(int spell, int[] potions, long target) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) spell * potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(0, potions.length - left);
    }
}
