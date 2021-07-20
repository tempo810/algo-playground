package leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Tempo
 */
public class ShuffleAnArray {
    private final int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] temp = Arrays.copyOf(nums, nums.length);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < temp.length; i++) {
            int randomIndex = random.nextInt(temp.length);
            int current = temp[i];
            temp[i] = temp[randomIndex];
            temp[randomIndex] = current;
        }
        return temp;
    }
}
