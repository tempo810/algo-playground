package leetcode;

/**
 * @author Tempo
 */
public class PaintHouse3 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[houses.length][n][target + 1];
        bottomUp(houses[0], cost[0], dp[0]);

        for (int i = 1; i < houses.length; i++) {
            int currentHouseColour = houses[i];
            int remainingHouse = houses.length - i - 1;
            int minTarget = Math.max(1, target - remainingHouse - 1);
            Integer[][] prevHouse = dp[i - 1];
            if (currentHouseColour == 0) {
                // colour
                for (int j = 0; j < prevHouse.length; j++) {
                    int currentColourCost = cost[i][j];
                    for (int k = 0; k < prevHouse.length; k++) {
                        for (int l = minTarget; l < prevHouse[k].length; l++) {
                            if (prevHouse[k][l] != null) {
                                int neighbour = j == k ? l : l + 1;
                                if (neighbour <= target) {
                                    int aggregatedCost = prevHouse[k][l] + currentColourCost;
                                    dp[i][j][neighbour] = dp[i][j][neighbour] == null ? aggregatedCost : Math.min(dp[i][j][neighbour], aggregatedCost);
                                }
                            }
                        }
                    }
                }
            } else {
                for (int k = 0; k < prevHouse.length; k++) {
                    for (int l = minTarget; l < prevHouse[k].length; l++) {
                        if (prevHouse[k][l] != null) {
                            int neighbour = currentHouseColour - 1 == k ? l : l + 1;
                            if (neighbour <= target) {
                                int aggregatedCost = prevHouse[k][l];
                                dp[i][currentHouseColour - 1][neighbour] = dp[i][currentHouseColour - 1][neighbour] == null ? aggregatedCost : Math.min(dp[i][currentHouseColour - 1][neighbour], aggregatedCost);
                            }
                        }
                    }
                }
            }
        }

        Integer result = null;
        Integer[][] costs = dp[houses.length - 1];
        for (Integer[] neighbours : costs) {
            if (neighbours[target] != null) {
                result = result == null ? neighbours[target] : Math.min(result, neighbours[target]);
            }
        }
        return result == null ? -1 : result;
    }

    private void bottomUp(int houseColour, int[] cost, Integer[][] dp) {
        if (houseColour == 0) {
            for (int i = 0; i < cost.length; i++) {
                dp[i][1] = cost[i];
            }
        } else {
            dp[houseColour - 1][1] = 0;
        }
    }
}
