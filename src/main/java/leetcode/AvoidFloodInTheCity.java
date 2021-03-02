package leetcode;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author tempo
 */
public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> dryCandidates = new TreeSet<>();
        HashMap<Integer, Integer> filledLakes = new HashMap<>(); // key = lake , value = index
        int[] result = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryCandidates.add(i);
                result[i] = 1;
            } else {
                Integer index = filledLakes.get(rains[i]);
                if (index != null) {
                    Integer dryDate = dryCandidates.higher(index);
                    if (dryDate == null) {
                        return new int[]{};
                    } else {
                        dryCandidates.remove(dryDate);
                        result[dryDate] = rains[i];
                    }
                }
                filledLakes.put(rains[i], i);
                result[i] = -1;
            }
        }
        return result;
    }
}
