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
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                int endIdx = i - 1;
                ret.add(formatRange(nums[startIdx], nums[endIdx]));
                startIdx = i;
            }
        }
        ret.add(formatRange(nums[startIdx], nums[nums.length - 1]));
        return ret;
    }

    private String formatRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return new StringBuilder().append(start).append('-').append('>').append(end).toString();
    }
}
