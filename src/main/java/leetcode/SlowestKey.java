package leetcode;

/**
 * @author Tempo
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] duration = new int[26];
        char[] keys = keysPressed.toCharArray();
        int lastDuration = 0;
        for (int i = 0; i < keys.length; i++) {
            int currentDuration = releaseTimes[i] - lastDuration;
            duration[keys[i] - 'a'] = Math.max(currentDuration, duration[keys[i] - 'a']);
            lastDuration = releaseTimes[i];
        }
        int largest = 0;
        for (int i = 1; i < duration.length; i++) {
            if (duration[i] >= duration[largest]) {
                largest = i;
            }
        }
        return (char) (largest + 'a');
    }
}
