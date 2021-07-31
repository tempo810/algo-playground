package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tempo
 */
public class AllElementsInTwoBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        inorder(root2, list2);

        List<Integer> results = new ArrayList<>(list1.size() + list2.size());
        int index = 0;
        int i = 0;
        int j = 0;
        while (index < list1.size() + list2.size()) {
            if (i == list1.size()) {
                results.add(list2.get(j++));
            } else if (j == list2.size()) {
                results.add(list1.get(i++));
            } else {
                if (list1.get(i) < list2.get(j)) {
                    results.add(list1.get(i++));
                } else {
                    results.add(list2.get(j++));
                }
            }
            index++;
        }
        return results;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
