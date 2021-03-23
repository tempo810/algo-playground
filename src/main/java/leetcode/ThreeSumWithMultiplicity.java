package leetcode;

import java.math.BigInteger;

/**
 * @author tempo
 */
public class ThreeSumWithMultiplicity {
    static BigInteger nCr(int n, int r) {
        return fact(n).divide(fact(r)).multiply(
                fact(n - r));
    }

    // Returns factorial of n
    static BigInteger fact(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

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
            BigInteger countV1 = nCr(occurrence[index], possibleDigit);
            count = rounding(countV1);
        }
        possibleDigit = Math.min(occurrence[index], possibleDigit);

        while (possibleDigit >= 0) {
            count = rounding(BigInteger.valueOf(count).add(nCr(occurrence[index], possibleDigit).multiply(BigInteger.valueOf(helperV2(occurrence, index + 1, target - index * possibleDigit, digit + possibleDigit)))));
            possibleDigit--;
        }
        return count;
    }

    private int rounding(BigInteger count) {
        return count.mod(BigInteger.valueOf((long) Math.pow(10, 9) + 7)).intValue();
    }
}
