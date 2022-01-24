package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int minLength = findLength(low);
        int maxLength = findLength(high) + 1;
        int currentLength = minLength;
        String digitSequence = "123456789";
        List<Integer> results = new ArrayList<>();
        while (currentLength < maxLength) {
            for (int i = 0; i < digitSequence.length() - currentLength; i++) {
                int value = Integer.parseInt(digitSequence.substring(i, i + currentLength));
                if (value >= low) {
                    if (value <= high) {
                        results.add(value);
                    } else {
                        break;
                    }
                }
            }
            currentLength++;
        }
        return results;
    }

    private int findLength(int value) {
        int length = 0;
        int val = value;
        while (val > 0) {
            val /= 10;
            length++;
        }
        return length;
    }

}
