package leetcode.leetcode75;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tempo
 */
class RecentCounter {
    private static int OFFSET = 3000;
    Queue<Integer> requests = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        int lowerBound = t - OFFSET;
        while (this.requests.peek() != null && this.requests.peek() < lowerBound) {
            this.requests.poll();
        }
        this.requests.add(t);
        return this.requests.size();
    }
}