package leetcode;

/**
 * @author tempo
 */
public class KMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int high = arr.length - 1;
        while (lo <= high) {
            int mid = (lo + high) / 2;
            if (arr[mid] >= mid + 1 + k) {
                high = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo + k;
    }
}
