import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Tempo
 */
public class Subsets {
    //DFS
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Deque<Integer> partial = new ArrayDeque<>();
        add(nums, 0, partial, results);
        return results;
    }

    private void add(int[] nums, int index, Deque<Integer> partial, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<>(partial));
        } else {
            add(nums, index + 1, partial, results);
            partial.addLast(nums[index]);
            add(nums, index + 1, partial, results);
            partial.removeLast();
        }
    }
}
