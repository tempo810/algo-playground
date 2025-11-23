package leetcode.leetcode75;

/**
 * @author tempo
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp *= nums[i];
            result[i] = tmp;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] *= nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int prefixProduct = i == 0 ? 1 : nums[i - 1];
            int suffixProduct = i == nums.length - 1 ? 1 : result[i + 1];
            result[i] = prefixProduct * suffixProduct;
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] * result[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            result[i] = tmp * result[i - 1];
            tmp *= nums[i];
        }
        result[0] = tmp;
        return result;
    }
}
