package leetcode;

/**
 * @author Tempo
 */
public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node construct(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        int count1 = 0;
        int count0 = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        if (count1 > 0 && count0 > 0) {
            Node node = new Node();
            node.topLeft = construct(grid, rowStart, rowEnd / 2, colStart, colEnd / 2);
            node.topRight = construct(grid, rowStart, rowEnd / 2, (colEnd / 2) + 1, colEnd);
            node.bottomLeft = construct(grid, (rowEnd / 2) + 1, rowEnd, colStart, colEnd / 2);
            node.bottomRight = construct(grid, (rowEnd / 2) + 1, rowEnd, (colEnd / 2) + 1, colEnd);
            return node;
        } else {
            return new Node(grid[rowStart][colStart] == 1, true);
        }
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;
}
