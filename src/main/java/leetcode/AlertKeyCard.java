package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class AlertKeyCard {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, PriorityQueue<Integer>> timeQueues = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String[] timeSplit = keyTime[i].split(":");
            int time = Integer.parseInt(timeSplit[0]) * 100 + Integer.parseInt(timeSplit[1]);
            PriorityQueue<Integer> times = timeQueues.computeIfAbsent(keyName[i], k -> new PriorityQueue<>());
            times.add(time);
        }

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, PriorityQueue<Integer>> userTimes : timeQueues.entrySet()) {
            PriorityQueue<Integer> timeQueue = new PriorityQueue<>();
            while (!userTimes.getValue().isEmpty()) {
                Integer currentTime = userTimes.getValue().remove();
                timeQueue.add(currentTime);
                if (timeQueue.size() == 3) {
                    Integer firstTracked = timeQueue.remove();
                    if (currentTime - firstTracked <= 100) {
                        result.add(userTimes.getKey());
                        break;
                    }
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
