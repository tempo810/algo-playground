package leetcode;

/**
 * @author tempo
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] root = new int[edges.length + 1];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (!this.union(edge[0], edge[1], root)) {
                return edge;
            }
        }
        return new int[]{-1, -1};
    }

    private int find(int i, int[] root) {
        if (root[i] != i) {
            root[i] = this.find(root[i], root);
        }
        return root[i];
    }

    private boolean union(int i, int j, int[] root) {
        int rootI = this.find(i, root);
        int rootJ = this.find(j, root);
        if (rootI == rootJ) {
            return false;
        } else if (rootI > rootJ) {
            root[rootI] = rootJ;
        } else {
            root[rootJ] = rootI;
        }
        return true;
    }
}
