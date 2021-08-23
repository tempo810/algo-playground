package leetcode;

/**
 * @author Tempo
 */
public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = Math.abs((ax2 - ax1) * (ay2 - ay1)) + Math.abs((bx2 - bx1) * (by2 - by1));
        int diffX = 0;
        int diffY = 0;

        if (bx1 > ax1 && bx1 < ax2) {
            diffX = Math.min(ax2 - bx1, bx2 - bx1);
        }

        if (ax1 > bx1 && ax1 < bx2) {
            diffX = Math.min(bx2 - ax1, ax2 - ax1);

        }

        if (bx2 > ax1 && bx2 < ax2) {
            diffX = Math.min(bx2 - ax1, bx2 - bx1);
        }

        if (ax2 > bx1 && ax2 < bx2) {
            diffX = Math.min(ax2 - bx1, ax2 - ax1);
        }

        if (by1 > ay1 && by1 < ay2) {
            diffY = Math.min(ay2 - by1, by2 - by1);
        }

        if (ay1 > by1 && ay1 < by2) {
            diffY = Math.min(by2 - ay1, ay2 - ay1);
        }

        if (by2 > ay1 && by2 < ay2) {
            diffY = Math.min(by2 - ay1, by2 - by1);
        }

        if (ay2 > by1 && ay2 < by2) {
            diffY = Math.min(ay2 - by1, ay2 - ay1);
        }

        if (ax1 == bx1 && ax2 == bx2) {
            diffX = ax2 - ax1;
        }

        if (ay1 == by1 && ay2 == by2) {
            diffY = by2 - by1;
        }

        return area - Math.abs(diffX * diffY);
    }
}
