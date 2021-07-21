package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Tempo
 */
class AlertKeyCardTest {
    private final AlertKeyCard solution = new AlertKeyCard();

    @Test
    void alertNamesV2() {
        assertThat(solution.alertNamesV2(new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"})).isEqualTo(List.of("daniel"));
    }
}
