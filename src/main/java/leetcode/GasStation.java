package leetcode;

/**
 * @author Tempo
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPos = -1;
        int totalGas = 0;
        int currentGas = 0;
        for (int i = 0; i < gas.length; i++) {
            int current = gas[i] - cost[i];
            currentGas += current;
            totalGas += current;

            if (currentGas < 0) {
                currentGas = 0;
                startPos = -1;
            } else if (startPos == -1) {
                startPos = i;
            }
        }

        return totalGas < 0 ? -1 : startPos;
    }
}
