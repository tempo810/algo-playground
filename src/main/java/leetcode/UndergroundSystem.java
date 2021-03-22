package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tempo
 */
public class UndergroundSystem {
    private final Map<Integer, Travel> onBoarding;
    private final Map<String, List<Travel>> records;

    public UndergroundSystem() {
        onBoarding = new HashMap<>();
        records = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!onBoarding.containsKey(id)) {
            var travel = new Travel();
            travel.startStation = stationName;
            travel.start = t;
            onBoarding.put(id, travel);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = onBoarding.remove(id);
        travel.endStation = stationName;
        travel.end = t;
        records.computeIfAbsent(travel.startStation, key -> new ArrayList<>()).add(travel);
    }

    public double getAverageTime(String startStation, String endStation) {
        int avg = 0;
        int count = 0;
        for (Travel travel : records.get(startStation)) {
            if (travel.endStation.equals(endStation)) {
                count++;
                avg += travel.end - travel.start;
            }
        }
        return (double) avg / count;
    }

    private static final class Travel {
        private String startStation;
        private int start;
        private int end;
        private String endStation;
    }
}
