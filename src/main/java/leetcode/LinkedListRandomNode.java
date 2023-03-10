package leetcode;

import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tempo
 */
public class LinkedListRandomNode {
    public static class Solution {
        List<ListNode> nodes = new ArrayList<>();

        public Solution(ListNode head) {
            while (head != null) {
                nodes.add(head);
                head = head.next;
            }
        }

        public int getRandom() {
            return nodes.get(ThreadLocalRandom.current().nextInt(nodes.size())).val;
        }
    }
}
