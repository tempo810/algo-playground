package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if (nums.length == 0) return ret;
        int startIdx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                int endIdx = i - 1;
                formatRange(sb, nums[startIdx], nums[endIdx]);
                ret.add(sb.toString());
                sb.setLength(0);
                startIdx = i;
            }
        }
        formatRange(sb, nums[startIdx], nums[nums.length - 1]);
        ret.add(sb.toString());
        return ret;
    }

    private void formatRange(StringBuilder sb, int start, int end) {
        sb.append(start);
        if (start != end) {
            sb.append('-').append('>').append(end);
        }
    }
}
