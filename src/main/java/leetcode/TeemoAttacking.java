package leetcode;

/**
 * @author tempo
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalPoisonedDuration = 0;
        int trackedPoisonedUntil = 0;

        for (int currentStart : timeSeries) {
            int currentPoisonUntil = currentStart + duration;
            if (currentStart > trackedPoisonedUntil) {
                totalPoisonedDuration += duration;
                trackedPoisonedUntil = currentPoisonUntil;
            } else if (currentPoisonUntil > trackedPoisonedUntil) {
                totalPoisonedDuration += currentPoisonUntil - trackedPoisonedUntil;
                trackedPoisonedUntil = currentPoisonUntil;
            }
        }
        return totalPoisonedDuration;
    }
}
