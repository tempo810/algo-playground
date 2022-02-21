package leetcode;

/**
 * @author tempo
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                majority = num;
            } else if (num == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}
