package leetcode;

import java.util.Map;

/**
 * @author tempo
 */
public class IntegerToRoman {
    Map<Integer, Character> lookupMap = Map.ofEntries(
            Map.entry(1, 'I'),
            Map.entry(5, 'V'),
            Map.entry(10, 'X'),
            Map.entry(50, 'L'),
            Map.entry(100, 'C'),
            Map.entry(500, 'D'),
            Map.entry(1000, 'M')
    );

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int current = num;
        int base = 1;
        while (current > 0) {
            int remainder = current % 10;
            char c = lookupMap.get(base);
            switch (remainder) {
                case 1:
                case 2:
                case 3:
                    for (int i = 0; i < remainder; i++) {
                        sb.insert(0, c);
                    }
                    break;
                case 4:
                    sb.insert(0, lookupMap.get(5 * base));
                    sb.insert(0, lookupMap.get(base));
                    break;
                case 5:
                    sb.insert(0, lookupMap.get(5 * base));
                    break;
                case 6:
                case 7:
                case 8:
                    c = lookupMap.get(base);
                    for (int i = 0; i < remainder - 5; i++) {
                        sb.insert(0, c);
                    }
                    sb.insert(0, lookupMap.get(5 * base));
                    break;
                case 9:
                    sb.insert(0, lookupMap.get(10 * base));
                    sb.insert(0, lookupMap.get(base));
                    break;
            }
            current /= 10;
            base *= 10;
        }
        return sb.toString();
    }
}
