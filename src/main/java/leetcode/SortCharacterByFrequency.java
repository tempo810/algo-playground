package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] frequency = new int[80];
        for (char c : chars) {
            frequency[c - '0']++;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                heap.add(frequency[i] * 100 + i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            Integer value = heap.poll();
            char c = (char) (value % 100 + '0');
            sb.append(String.valueOf(c).repeat(Math.max(0, value / 100)));
        }
        return sb.toString();
    }
}
