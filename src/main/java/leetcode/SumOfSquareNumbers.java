package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tempo
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squareNumbers = new HashSet<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            double squareNumber = Math.pow(i, 2);

            if (squareNumber > c) {
                return false;
            }

            squareNumbers.add((int) squareNumber);
            int target = c - (int) squareNumber;
            if (squareNumbers.contains(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSumV2(int c) {
        int start = 0;
        int end = (int) Math.sqrt(c);
        while (start <= end) {
            int result = start * start + end * end;
            if (result == c) {
                return true;
            }
            if (result < c) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
