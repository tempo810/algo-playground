package leetcode;

/**
 * @author Tempo
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int minUnorderedIndex = -1;
        int maxUnorderedIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (minUnorderedIndex == -1 || nums[i] < nums[minUnorderedIndex]) {
                    minUnorderedIndex = i;
                }
                if (maxUnorderedIndex == -1 || nums[i - 1] > nums[maxUnorderedIndex]) {
                    maxUnorderedIndex = i - 1;
                }
            }
        }
        if (minUnorderedIndex == -1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (nums[left] <= nums[minUnorderedIndex]) {
            left++;
        }

        while (nums[right] >= nums[maxUnorderedIndex]) {
            right--;
        }

        return right - left + 1;
    }
}
