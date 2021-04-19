package misc;

import java.util.Collections;
import java.util.List;

/**
 * @author Tempo
 */
public class FindAllCombinationOfBudgets {
    public int find(List<List<Integer>> productLists, int budget) {
        for (List<Integer> productList : productLists) {
            Collections.sort(productList);
        }
        return dfs(productLists, 0, budget);
    }

    private int dfs(List<List<Integer>> productLists, int index, int budget) {
        int count = 0;
        for (int i = 0; i < productLists.get(index).size(); i++) {
            if (productLists.get(index).get(i) > budget) {
                break;
            }
            if (index < productLists.size() - 1) {
                count += dfs(productLists, index + 1, budget - productLists.get(index).get(i));
            } else {
                count++;
            }
        }
        return count;
    }
}
