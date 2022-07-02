package leetcode;

/**
 * @author Tempo
 */
public class RangeSumQuery {
    private final int[] nums;
    private final int[] binaryIndexedTree;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.binaryIndexedTree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int currentIndex = i + 1;
            while (currentIndex <= binaryIndexedTree.length - 1) {
                binaryIndexedTree[currentIndex] += val;
                currentIndex += (currentIndex & -currentIndex);
            }
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        if (diff != 0) {
            int currentIndex = index + 1;
            while (currentIndex <= binaryIndexedTree.length - 1) {
                binaryIndexedTree[currentIndex] += diff;
                currentIndex += (currentIndex & -currentIndex);
            }
            nums[index] = val;
        }
    }

    public int sumRange(int left, int right) {
        return get(right + 1) - get(left);
    }

    private int get(int index) {
        int currentIndex = index;
        int val = 0;
        while (currentIndex > 0) {
            val += binaryIndexedTree[currentIndex];
            currentIndex -= (currentIndex & -currentIndex);
        }
        return val;
    }
}
