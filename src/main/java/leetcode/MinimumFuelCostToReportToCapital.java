package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class MinimumFuelCostToReportToCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] connectedRoads = new List[roads.length + 1];
        for (int i = 0; i < connectedRoads.length; i++) {
            connectedRoads[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            connectedRoads[road[0]].add(road[1]);
            connectedRoads[road[1]].add(road[0]);

        }
        long[] currentSeated = new long[roads.length + 1];
        return dfs(0, connectedRoads, currentSeated, seats);
    }

    private long dfs(int currentStop, List<Integer>[] connectedRoads, long[] currentSeated, int seatCapacity) {
        if (currentSeated[currentStop] != 0) {
            return 0;
        }

        currentSeated[currentStop]++;
        long totalFuel = 0;
        for (Integer nextStop : connectedRoads[currentStop]) {
            if (currentSeated[nextStop] == 0) {
                totalFuel += dfs(nextStop, connectedRoads, currentSeated, seatCapacity);
                currentSeated[currentStop] += currentSeated[nextStop];
            }
        }
        if (currentStop != 0) {
            totalFuel += Math.ceil((double) currentSeated[currentStop] / seatCapacity);
        }
        return totalFuel;
    }
}
