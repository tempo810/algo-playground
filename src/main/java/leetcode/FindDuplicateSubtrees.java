package leetcode;

import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tempo
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> hashes = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        dfs(root, hashes, result, new StringBuilder());
        return result;
    }

    private String dfs(TreeNode root, Map<String, Integer> hashes, List<TreeNode> result, StringBuilder sb) {
        String lTree = root.left != null ? dfs(root.left, hashes, result, sb) : null;
        String rTree = root.right != null ? dfs(root.right, hashes, result, sb) : null;

        if (lTree != null) {
            sb.append("lt:");
            sb.append(lTree);
        }

        sb.append("root:");
        sb.append(root.val);

        if (rTree != null) {
            sb.append("rt:");
            sb.append(rTree);
        }

        final String hash = sb.toString();
        final Integer count = hashes.compute(hash, (k, v) -> v == null ? 1 : v + 1);
        if (count == 2) {
            result.add(root);
        }
        sb.setLength(0);
        return hash;
    }
}
