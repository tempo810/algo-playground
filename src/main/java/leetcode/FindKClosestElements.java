package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tempo
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            index = -index - 1;
        }
        int low, high;
        if (index == arr.length) {
            low = arr.length - 1;
            high = arr.length;
        } else if (arr[index] == x) {
            result.add(arr[index]);
            low = index - 1;
            high = index + 1;
        } else {
            low = index - 1;
            high = index;
        }

        while (result.size() < k) {
            if (low == -1) {
                result.addLast(arr[high++]);
            } else if (high == arr.length || x - arr[low] <= arr[high] - x) {
                result.addFirst(arr[low--]);
            } else {
                result.addLast(arr[high++]);
            }
        }

        return result;
    }
}
