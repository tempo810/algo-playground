package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
            }
            result.add(1);
            results.add(result);
        }
        return results;
    }
}
