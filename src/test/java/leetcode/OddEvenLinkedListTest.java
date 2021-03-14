package leetcode;

import leetcode.datastructure.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class OddEvenLinkedListTest {
    private final OddEvenLinkedList solution = new OddEvenLinkedList();

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        solution.oddEvenList(head);
    }
}
