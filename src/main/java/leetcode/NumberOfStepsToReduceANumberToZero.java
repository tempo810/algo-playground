package leetcode;

/**
 * @author Tempo
 */
public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int step = 0;
        int currentValue = num;
        while (currentValue != 0) {
            if ((currentValue & 1) == 1) {
                currentValue--;
            } else {
                currentValue >>= 1;
            }
            step++;
        }
        return step;
    }
}
