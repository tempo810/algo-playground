package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tempo
 */
public class IntersectionOf2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> results = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                results.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] array = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            array[i] = results.get(i);
        }
        return array;
    }
}
