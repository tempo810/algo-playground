package leetcode;

import java.util.Arrays;

/**
 * @author Tempo
 */
public class MatchSticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        if (matchsticks.length < 4) {
            return false;
        }
        return dfs(matchsticks, 1, 0, -1);
    }

    private boolean dfs(int[] matchsticks, int segment, int fromIndex, int targetSegmentValue) {
        if (segment == 5) {
            return fromIndex == matchsticks.length;
        }
        int remainingSegment = 4 - segment;
        int possibleSegments = matchsticks.length - fromIndex - remainingSegment;
        int currentSegmentValue = 0;
        for (int i = 0; i < possibleSegments; i++) {
            currentSegmentValue += matchsticks[fromIndex + i];
            if (targetSegmentValue == -1 || targetSegmentValue == currentSegmentValue) {
                if (dfs(matchsticks, segment + 1, fromIndex + i, currentSegmentValue)) {
                    return true;
                }
            }
        }
        return false;
    }
}
