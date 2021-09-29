package leetcode;

/**
 * @author Tempo
 */
public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        int evenIndex = 0;

        while (evenIndex < nums.length && oddIndex < nums.length) {
            if (nums[evenIndex] % 2 != 0 && nums[oddIndex] % 2 != 1) {
                nums[evenIndex] ^= nums[oddIndex];
                nums[oddIndex] ^= nums[evenIndex];
                nums[evenIndex] ^= nums[oddIndex];
                evenIndex += 2;
                oddIndex += 2;
                continue;
            }
            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
            if (nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
        }

        return nums;
    }
}
