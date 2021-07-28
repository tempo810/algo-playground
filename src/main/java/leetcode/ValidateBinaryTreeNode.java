package leetcode;

/**
 * @author Tempo
 */
public class ValidateBinaryTreeNode {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] nodes = new boolean[n];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                if (nodes[leftChild[i]]) {
                    return false;
                }
                nodes[leftChild[i]] = true;
            }
            if (rightChild[i] != -1) {
                if (nodes[rightChild[i]]) {
                    return false;
                }
                nodes[rightChild[i]] = true;
            }
        }
        Integer root = null;
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i]) {
                if (root != null) {
                    return false;
                } else {
                    root = i;
                }
            }
        }

        if (root == null) {
            return false;
        }

        boolean[] visited = new boolean[n];
        if (!dfs(root, leftChild, rightChild, visited)) {
            return false;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (visited[root]) {
            return false;
        }
        visited[root] = true;
        int left = leftChild[root];
        if (left != -1 && !dfs(left, leftChild, rightChild, visited)) {
            return false;
        }
        int right = rightChild[root];
        return right == -1 || dfs(right, leftChild, rightChild, visited);
    }
}
