package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tempo
 */
public class UndergroundSystem {
    private final Map<Integer, Travel> onBoarding;
    private final Map<String, Record> records;

    public UndergroundSystem() {
        onBoarding = new HashMap<>();
        records = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        var travel = new Travel();
        travel.startStation = stationName;
        travel.start = t;
        onBoarding.put(id, travel);
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = onBoarding.remove(id);
        final Record record = records.computeIfAbsent(travel.startStation + ":" + stationName, key -> new Record());
        record.totalTravelTime += t - travel.start;
        record.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        final Record record = records.get(startStation + ":" + endStation);
        return (double) record.totalTravelTime / record.count;
    }

    private static final class Travel {
        private String startStation;
        private int start;
    }

    private static final class Record {
        private int totalTravelTime = 0;
        private int count = 0;

    }
}
