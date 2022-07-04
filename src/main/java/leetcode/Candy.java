package leetcode;

/**
 * @author Tempo
 */
public class Candy {

    public int candy(int[] ratings) {
        int[] increasingSequences = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                increasingSequences[i] = increasingSequences[i - 1] + 1;
            }
        }
        int total = increasingSequences[increasingSequences.length - 1] + 1;
        int currentIncreasing = 0;
        for (int i = increasingSequences.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                currentIncreasing++;
            } else {
                currentIncreasing = 0;
            }
            total += Math.max(currentIncreasing, increasingSequences[i]) + 1;
        }

        return total;
    }
}
