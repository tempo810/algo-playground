package leetcode.leetcode75;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tempo
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesSequence1 = new ArrayList<>();
        List<Integer> leavesSequence2 = new ArrayList<>();
        getLeaf(root1, leavesSequence1);
        getLeaf(root2, leavesSequence2);
        return leavesSequence1.equals(leavesSequence2);
    }

    private void getLeaf(TreeNode root, List<Integer> sequence) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                sequence.add(root.val);
            } else {
                getLeaf(root.left, sequence);
                getLeaf(root.right, sequence);
            }
        }
    }
}
