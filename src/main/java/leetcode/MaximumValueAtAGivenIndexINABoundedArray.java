package leetcode;

/**
 * @author tempo
 */
public class MaximumValueAtAGivenIndexINABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int min = 0;
        int max = maxSum;
        int right = n - index - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            long minLeft = findMin(index, mid - 1);
            long minRight = findMin(right, mid - 1);
            if ((long) mid + minLeft + minRight > maxSum) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return max <= 0 ? 1 : max;
    }

    private long findMin(int lengthToFill, int initialValue) {
        if (initialValue == 0 || lengthToFill == 0) return 0;
        int maxLengthToFill = Math.min(initialValue, lengthToFill);
        long value;
        if (maxLengthToFill == 1) {
            value = initialValue;
        } else {
            long pairSum = ((long) initialValue + initialValue - maxLengthToFill + 1);
            value = pairSum * (maxLengthToFill / 2);
            if (maxLengthToFill % 2 == 1) {
                value += pairSum / 2;
            }
        }
        return value + (lengthToFill - maxLengthToFill);
    }
}
