package leetcode;

/**
 * @author tempo
 */
public class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        int[] in = new int[101];
        int[] sum1 = new int[201];
        int[] sum2 = new int[301];
        int result = 0;
        for (int num : nums) {
            result += sum2[num];
            for (int i = 0; i < sum1.length; i++) {
                sum2[i + num] += sum1[i];
            }
            for (int i = 0; i < in.length; i++) {
                sum1[i + num] += in[i];
            }
            in[num]++;
        }
        return result;
    }
}
