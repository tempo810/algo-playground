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
}
