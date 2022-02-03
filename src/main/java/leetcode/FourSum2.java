package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> hash1 = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                hash1.compute((num1 + num2), (key, value) -> value == null ? 1 : value + 1);
            }
        }

        int result = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                result += hash1.getOrDefault((num3 + num4) * -1, 0);
            }
        }
        return result;
    }
}
