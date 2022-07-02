package leetcode.datastructure;

/**
 * @author Tempo
 */
public class BinaryIndexedTree {
    private final int[] nodes;
    private final int[] nums;

    public BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        nodes = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            setDiff(i + 1, nums[i]);
        }
    }

    public int get(int index) {
        int val = 0;
        int currentIndex = index + 1;
        while (currentIndex > 0) {
            val += nodes[currentIndex];
            currentIndex -= (currentIndex & -currentIndex);
        }
        return val;
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        if (diff > 0) {
            nums[index] = val;
            setDiff(index + 1, diff);
        }
    }

    public int query(int val) {
        int low = 1;
        int high = nodes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int current = get(mid);
            if (current >= val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private void setDiff(int index, int diff) {
        int currentIndex = index;
        while (currentIndex < nodes.length) {
            nodes[currentIndex] += diff;
            currentIndex += (currentIndex & -currentIndex);
        }
    }
}
