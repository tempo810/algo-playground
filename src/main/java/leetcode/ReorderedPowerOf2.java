package leetcode;

import java.util.Arrays;

/**
 * @author tempo
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        int[] frequency = new int[10];
        int numberOfDigit = 0;
        int value = n;
        while (value > 0) {
            int temp = value / 10 * 10;
            frequency[value - temp]++;
            value /= 10;
            numberOfDigit++;
        }

        int totalShift;
        int startShift = (numberOfDigit - 1) / 3 * 10;
        int mod = numberOfDigit % 3;
        if (mod == 1) {
            totalShift = 4;
        } else if (mod == 2) {
            totalShift = 3;
            startShift += 4;
        } else {
            totalShift = 3;
            startShift += 7;
        }

        int currentShift = 1;
        int[] targetFrequency = new int[10];
        while (currentShift++ <= totalShift) {
            int currentNumber = 1 << startShift;
            while (currentNumber > 0) {
                int temp = currentNumber / 10 * 10;
                targetFrequency[currentNumber - temp]++;
                currentNumber /= 10;
            }
            if (Arrays.equals(frequency, targetFrequency)) {
                return true;
            }
            Arrays.fill(targetFrequency, 0);
            startShift++;
        }
        return false;
    }
}
