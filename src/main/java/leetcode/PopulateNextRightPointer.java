package leetcode;


import leetcode.datastructure.Node;

/**
 * @author Tempo
 */
public class PopulateNextRightPointer {
    // bfs
    public Node connect(Node root) {
        Node cursor = root;
        while (cursor != null && cursor.left != null) {
            cursor.left.next = cursor.right;
            if (cursor.next != null) {
                cursor.right.next = cursor.next.left;
            }
            cursor = cursor.next;
        }
        if (root != null) {
            connect(root.left);
        }
        return root;
    }
}
