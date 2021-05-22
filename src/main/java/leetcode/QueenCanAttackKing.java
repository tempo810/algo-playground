package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class QueenCanAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<Integer> left = null;
        List<Integer> right = null;
        List<Integer> top = null;
        List<Integer> bottom = null;
        List<Integer> leftTop = null;
        List<Integer> leftBottom = null;
        List<Integer> rightTop = null;
        List<Integer> rightBottom = null;

        for (int[] queen : queens) {
            if (queen[0] == king[0]) {
                if (queen[1] < king[1]) {
                    if (left == null || left.get(1) < queen[1]) {
                        left = List.of(queen[0], queen[1]);
                    }
                } else {
                    if (right == null || right.get(1) > queen[1]) {
                        right = List.of(queen[0], queen[1]);
                    }
                }
            } else if (queen[1] == king[1]) {
                if (queen[0] < king[0]) {
                    if (top == null || top.get(0) < queen[0]) {
                        top = List.of(queen[0], queen[1]);
                    }
                } else {
                    if (bottom == null || bottom.get(0) > queen[0]) {
                        bottom = List.of(queen[0], queen[1]);
                    }
                }
            } else if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                if (queen[0] - king[0] > 0 && queen[1] - king[1] > 0) {
                    if (rightBottom == null || rightBottom.get(0) > queen[0]) {
                        rightBottom = List.of(queen[0], queen[1]);
                    }
                } else if (queen[0] - king[0] < 0 && queen[1] - king[1] < 0) {
                    if (leftTop == null || leftTop.get(0) < queen[0]) {
                        leftTop = List.of(queen[0], queen[1]);
                    }
                } else if (queen[0] - king[0] < 0 && queen[1] - king[1] > 0) {
                    if (leftBottom == null || leftBottom.get(0) < queen[0]) {
                        leftBottom = List.of(queen[0], queen[1]);
                    }
                } else {
                    if (rightTop == null || rightTop.get(0) > queen[0]) {
                        rightTop = List.of(queen[0], queen[1]);
                    }
                }
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        if (right != null) {
            results.add(right);
        }
        if (left != null) {
            results.add(left);
        }
        if (top != null) {
            results.add(top);
        }
        if (bottom != null) {
            results.add(bottom);
        }
        if (rightTop != null) {
            results.add(rightTop);
        }
        if (rightBottom != null) {
            results.add(rightBottom);
        }
        if (leftTop != null) {
            results.add(leftTop);
        }
        if (leftBottom != null) {
            results.add(leftBottom);
        }
        return results;
    }
}
