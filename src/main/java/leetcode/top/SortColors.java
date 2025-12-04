package leetcode.top;

/**
 * @author tempo
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
            } else if (num == 1) {
                countOne++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < countZero) {
                nums[i] = 0;
            } else if (i < countZero + countOne) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
