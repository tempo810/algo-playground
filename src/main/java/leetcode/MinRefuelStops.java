package leetcode;

import java.util.PriorityQueue;

/**
 * @author Tempo
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        return dfs(target, startFuel, stations, -1, 0);
    }

    private int dfs(int target, int totalFuel, int[][] stations, int lastStation, int totalRefuel) {
        if (totalFuel >= target) {
            return totalRefuel;
        }
        int result = Integer.MAX_VALUE;
        for (int i = lastStation + 1; i < stations.length; i++) {
            if (stations[i][0] > totalFuel) {
                break;
            }
            int localRes = dfs(target, totalFuel + stations[i][1], stations, i, totalRefuel + 1);
            if (localRes != -1) {
                result = Math.min(result, localRes);
            }
        }

        return result != Integer.MAX_VALUE ? result : -1;
    }

    public int minRefuelStopsHeap(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        int minStop = 0;
        int totalFuel = startFuel;

        for (int[] station : stations) {
            while (totalFuel < station[0]) {
                if (maxHeap.isEmpty()) {
                    return -1;
                }
                totalFuel += maxHeap.remove();
                minStop++;
            }

            maxHeap.offer(station[1]);
        }

        while (totalFuel < target) {
            if (maxHeap.isEmpty()) {
                return -1;
            }
            totalFuel += maxHeap.remove();
            minStop++;
        }
        return minStop;
    }
}
