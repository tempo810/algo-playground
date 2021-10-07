package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class FindAllDuplicatedInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num] < 0) {
                duplicates.add(num);
            } else {
                nums[num] *= -1;
            }
        }
        return duplicates;
    }
}
