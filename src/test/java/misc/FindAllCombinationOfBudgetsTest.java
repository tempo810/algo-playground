package misc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tempo
 */
class FindAllCombinationOfBudgetsTest {
    private final FindAllCombinationOfBudgets budgets = new FindAllCombinationOfBudgets();

    @Test
    void find() {
        List<List<Integer>> products = new ArrayList<>();
        products.add(Arrays.asList(1, 2, 3));
        products.add(Arrays.asList(4, 5, 6));
        products.add(Arrays.asList(7, 8, 9));
        assertThat(budgets.find(products, 13)).isEqualTo(4);
        assertThat(budgets.find(products, 10)).isEqualTo(0);
        assertThat(budgets.find(products, 11)).isEqualTo(0);
        assertThat(budgets.find(products, 12)).isEqualTo(1);
        assertThat(budgets.find(products, 18)).isEqualTo(27);
    }
}
