package leetcode;

/**
 * @author Tempo
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // [2,  4,  6,  8]
        // [2,  8,  48, 384]
        // [384,192, 48   ,8]

        answer[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i] * answer[i - 1];
        }

        int right = 1;
        for (int i = answer.length - 1; i > 0; i--) {
            answer[i] = right * answer[i - 1];
            right *= nums[i];
        }
        return answer;
    }
}
