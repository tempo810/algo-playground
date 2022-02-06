package leetcode;

/**
 * @author Tempo
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int currentSorted = 1;

        for (int i = 1; i < nums.length; i++) {
            if (currentSorted == 1 || nums[currentSorted - 1] != nums[currentSorted - 2] || nums[i] != nums[currentSorted - 1]) {
                nums[currentSorted++] = nums[i];
            }
        }

        return currentSorted;
    }
}
