package leetcode;

/**
 * @author Tempo
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            if (index1 < 0 || nums2[index2] > nums1[index1]) {
                nums1[index1 + index2 + 1] = nums2[index2];
                index2--;
            } else {
                nums1[index1 + index2 + 1] = nums1[index1];
                index1--;
            }
        }
    }
}
