package leetcode;

/**
 * @author tempo
 */
public class ThreeSumWithMultiplicity {
    static long nCr(int n, int r) {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static long fact(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

//    public int threeSumMulti(int[] arr, int target) {
//        Arrays.sort(arr);
//        return helper(0, 0, arr, target, 0);
//    }
//
//    private int helper(int index, int total, int[] arr, int target, int size) {
//        if (index >= arr.length || size >= 3) {
//            return total;
//        }
//        int result = helper(index + 1, total, arr, target, size);
//        if (target == arr[index] && size == 2) {
//            return (result + 1) % (int) (Math.pow(10, 9) + 7);
//        } else if (target - arr[index] >= 0) {
//            result = helper(index + 1, result, arr, target - arr[index], size + 1);
//        }
//        return result;
//    }

    public int threeSumMultiV2(int[] arr, int target) {
        int[] occurrence = new int[101];
        for (int val : arr) {
            occurrence[val]++;
        }
        return helperV2(occurrence, 0, target, 0);
    }

    private int helperV2(int[] occurrence, int index, int target, int digit) {
        if (index >= occurrence.length || target < 0 || index > target) {
            return 0;
        }
        int possibleDigit = 3 - digit;
        int count = 0;
        if (possibleDigit * index == target && possibleDigit <= occurrence[index]) {
            long countV1 = nCr(occurrence[index], possibleDigit);
            count = rounding(countV1);
        }
        possibleDigit = Math.min(occurrence[index], possibleDigit);

        while (possibleDigit >= 0) {
            count = rounding(count + nCr(occurrence[index], possibleDigit) * helperV2(occurrence, index + 1, target - index * possibleDigit, digit + possibleDigit));
            possibleDigit--;
        }
        return count;
    }

    private int rounding(long count) {
        return (int) (count % (Math.pow(10, 9) + 7));
    }
}
