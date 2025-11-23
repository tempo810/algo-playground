package leetcode.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tempo
 */
public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] num1Seen = new boolean[2001];
        for (int num : nums1) {
            num1Seen[num + 1000] = true;
        }

        boolean[] num2Seen = new boolean[2001];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (!num2Seen[num + 1000]) {
                num2Seen[num + 1000] = true;
                if (!num1Seen[num + 1000]) {
                    list2.add(num);
                }
            }
        }

        Arrays.fill(num1Seen, false);
        for (int num : nums1) {
            if (!num1Seen[num + 1000]) {
                num1Seen[num + 1000] = true;
                if (!num2Seen[num + 1000]) {
                    list1.add(num);
                }
            }
        }
        return List.of(list1, list2);

    }
}
