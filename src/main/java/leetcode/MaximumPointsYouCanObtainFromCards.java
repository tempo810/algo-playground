package leetcode;

/**
 * @author Tempo
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int minRemovalWindow = 0;
        int currentRemoveWindows = 0;
        int n = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++) {
            total += cardPoints[i];
            currentRemoveWindows += cardPoints[i];
            if (i < n) {
                minRemovalWindow = currentRemoveWindows;
            } else {
                currentRemoveWindows -= cardPoints[i - n];
                minRemovalWindow = Math.min(minRemovalWindow, currentRemoveWindows);
            }
        }
        return total - minRemovalWindow;
    }

    public int maxScorePrefixSum(int[] cardPoints, int k) {
        if (k == 0) {
            return 0;
        }

        int[] prefix = new int[k + 1];
        for (int i = 0; i < k; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }

        int[] suffix = new int[k + 1];
        for (int i = 0; i < k; i++) {
            suffix[i + 1] = suffix[i] + cardPoints[cardPoints.length - 1 - i];
        }

        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            maxScore = Math.max(maxScore, prefix[i] + suffix[k - i]);
        }
        return maxScore;
    }
}
