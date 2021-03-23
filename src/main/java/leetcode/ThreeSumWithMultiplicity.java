package leetcode;

/**
 * @author tempo
 */
public class ThreeSumWithMultiplicity {
    static long printNcR(int n, int r) {

        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        long p = 1, k = 1;

        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }

        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;

                // gcd of p, k
                long m = __gcd(p, k);

                // dividing by gcd, to simplify
                // product division by their gcd
                // saves from the overflow
                p /= m;
                k /= m;

                n--;
                r--;
            }

            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        } else {
            p = 1;
        }

        return p;
    }

    static long __gcd(long n1, long n2) {
        long gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
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
            count = rounding(printNcR(occurrence[index], possibleDigit));
        }
        possibleDigit = Math.min(occurrence[index], possibleDigit);

        while (possibleDigit >= 0) {
            count = rounding(count + printNcR(occurrence[index], possibleDigit) * helperV2(occurrence, index + 1, target - index * possibleDigit, digit + possibleDigit));
            possibleDigit--;
        }
        return count;
    }

    private int rounding(long count) {
        return (int) (count % 1_000_000_007);
    }
}
