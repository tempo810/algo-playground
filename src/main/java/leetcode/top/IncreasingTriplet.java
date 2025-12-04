package leetcode.top;

/**
 * @author tempo
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lowest) {
                lowest = nums[i];
            } else if (nums[i] < secondLowest) {
                secondLowest = nums[i];
            } else if (nums[i] > secondLowest) {
                return true;
            }
        }
        return false;
    }
}
